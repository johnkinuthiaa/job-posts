package com.slippery.jobposts.controller;

import com.slippery.jobposts.dto.UserDto;
import com.slippery.jobposts.model.User;
import com.slippery.jobposts.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class UserController {
    private final UserService service;
    public UserController(UserService service){
        this.service=service;
    }
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody User user){
        return ResponseEntity.ok(service.register(user));
    }
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody User user){
        return ResponseEntity.ok(service.login(user));
    }
}

