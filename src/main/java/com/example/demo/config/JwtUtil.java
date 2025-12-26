package com.example.demo.config;

import com.example.demo.model.User;

public class JwtUtil {
    public String generateToken(User user) {
        return "dummy-token";
    }

    public boolean validateToken(String token) {
        return token != null;
    }
}
