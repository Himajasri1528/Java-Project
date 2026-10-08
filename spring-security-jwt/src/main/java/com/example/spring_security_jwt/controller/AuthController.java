package com.example.spring_security_jwt.controller;

import com.example.spring_security_jwt.entity.User;
import com.example.spring_security_jwt.repository.UserRepository;
import com.example.spring_security_jwt.security.JwtService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public AuthController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager =
                authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public String register(
            @RequestBody User user) {

        user.setPassword(
                passwordEncoder.encode(
                        user.getPassword()));

        if (user.getRole() == null) {

            user.setRole("USER");
        }

        userRepository.save(user);

        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(
            @RequestBody User user) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                user.getUsername(),
                                user.getPassword()
                        )
                );

        if (authentication.isAuthenticated()) {

            return jwtService.generateToken(
                    user.getUsername());
        }

        return "Login failed";
    }
}