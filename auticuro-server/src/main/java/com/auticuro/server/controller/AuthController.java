package com.auticuro.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Endpoint for user registration
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        // Here you would add logic to save the user to the database
        // For simplicity, we just return a success message
        String encodedPassword = passwordEncoder.encode(password);
        return "User registered successfully with encoded password: " + encodedPassword;
    }

    // Endpoint for user login
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        // Here you would add logic to authenticate the user
        // For simplicity, we just return a success message
        return "User logged in successfully";
    }
}
