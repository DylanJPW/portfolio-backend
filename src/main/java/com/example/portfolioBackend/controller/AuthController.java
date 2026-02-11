package com.example.portfolioBackend.controller;

import com.example.portfolioBackend.auth.JWTUtil;
import com.example.portfolioBackend.model.auth.UserDetailsRequest;
import com.example.portfolioBackend.model.auth.UserDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDetailsRequest userDetailsRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDetailsRequest.getUsername(),
                        userDetailsRequest.getPassword()
                )
        );

        String token = jwtUtil.generateToken(userDetailsRequest.getUsername());
        return ResponseEntity.ok(new UserDetailsResponse(token));
    }
}
