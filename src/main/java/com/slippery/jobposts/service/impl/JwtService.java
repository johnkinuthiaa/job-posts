package com.slippery.jobposts.service.impl;

import com.slippery.jobposts.dto.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private final String SECRETKEY ="17eb6349f3963f0b8831423696a0e2628cbddfeec31aac502ad420035eea508518a95706ad6ab4ca6824f5de57c7d28b74103fff79455942d73e7c5f1639a8c53784f0a01549b06120224ea0c0c05c6d331c4976d893d775ff7a47c16a5d055229585b7279747552ca62eadd7a11fed259b70e74c851eb6945c8e0ca5a29989a4a10c9418055702cac7b153b583b1b0a0b66b1919e75b574d4cb9e8fa3b66f26c007422541f588b37dc91b9403c57b68617a402975e240cf7a7d0bf8530527346b330db11914223a49619f6fee71b8deb50ba14517ccef9f82a3b2ed7eb7a49bce8394e48578ed72622b7448f98e2062032e9182c31c01c52214b815c59a2bd1";
    private final Long EXPIRATIONTIME =3600000L;

    protected SecretKey generateKey(){
        byte[] keyBytes = Base64.getDecoder().decode(SECRETKEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public UserDto generateJwtToken(String username){
        UserDto response =new UserDto();
        Map<String,Object> claims =new HashMap<>();
        var token =Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()))
                .and()
                .signWith(generateKey())
                .compact();
        response.setJwtToken(token);
        return response;

    }
    public String extractUsername(String token){
        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction) {
        return claimsTFunction.apply(Jwts.parser().verifyWith(generateKey()).build().parseSignedClaims(token).getPayload());

    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }
}
