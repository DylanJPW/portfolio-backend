package com.example.portfolioBackend.model.auth;

public class UserDetailsResponse {
    private String token;
    public UserDetailsResponse(String token) { this.token = token; }
    public String getToken() { return token; }
}
