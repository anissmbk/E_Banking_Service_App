package com.example.ebankingspg.java.response;

import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticationResponse {

    private final String jwt;
    private final UserDetails user;

    public AuthenticationResponse(String jwt, UserDetails userdetails) {
        this.jwt = jwt;
        this.user = userdetails;
    }

    public String getJwt() {
        return jwt;
    }


    public UserDetails getUser() {
        return user;
    }
}
