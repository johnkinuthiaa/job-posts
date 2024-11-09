package com.slippery.jobposts.service.impl;

import com.slippery.jobposts.dto.UserDto;
import com.slippery.jobposts.model.User;
import com.slippery.jobposts.repository.UserRepository;
import com.slippery.jobposts.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private PasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserServiceImpl(UserRepository repository, AuthenticationManager authenticationManager,JwtService jwtService) {
        this.repository = repository;
        this.authenticationManager = authenticationManager;
        this.jwtService=jwtService;
    }

    @Override
    public UserDto register(User user) {
        UserDto response =new UserDto();
        if(repository.findByUsername(user.getUsername()) ==null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            repository.save(user);
            response.setMessage(user.getUsername()+" successfully registered ");
            response.setStatusCode(200);
        }else{
            response.setStatusCode(500);
            response.setMessage("user with name "+user.getUsername()+" already exists");
        }
        return response;

    }

    @Override
    public UserDto login(User user) {
        UserDto response =new UserDto();
        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword()
        ));
        if(authentication.isAuthenticated()){
            var token =jwtService.generateJwtToken(user.getUsername());
            response.setJwtToken(token.getJwtToken());
            response.setMessage(user.getUsername()+" successfully logged in");
            response.setStatusCode(200);
        }else{
            response.setMessage(user.getUsername()+" not logged in successfully");
            response.setStatusCode(500);
        }
        return response;
    }
}
