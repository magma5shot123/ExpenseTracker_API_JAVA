package com.example.EXPENSE_TRACKER_API.controller;

import com.example.EXPENSE_TRACKER_API.dto.auth.AuthResponse;
import com.example.EXPENSE_TRACKER_API.dto.auth.LoginRequest;
import com.example.EXPENSE_TRACKER_API.dto.auth.RegisterRequest;
import com.example.EXPENSE_TRACKER_API.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest dto) {
        return authService.login(dto);
    }

    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegisterRequest dto) {
        return authService.register(dto);
    }
}
