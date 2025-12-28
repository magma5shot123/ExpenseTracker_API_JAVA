package com.example.EXPENSE_TRACKER_API.service;

import com.example.EXPENSE_TRACKER_API.dto.auth.AuthResponse;
import com.example.EXPENSE_TRACKER_API.dto.auth.LoginRequest;
import com.example.EXPENSE_TRACKER_API.dto.auth.RegisterRequest;
import com.example.EXPENSE_TRACKER_API.entity.User;
import com.example.EXPENSE_TRACKER_API.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse login(LoginRequest dto) {
        if (!userRepository.existsByEmail(dto.email())) {
            return new AuthResponse(false, "Invalid email or password");
        }
        if (dto.password() == null || !passwordEncoder.matches(dto.password(),userRepository.findByEmail(dto.email()).getPassword())) {
            return new AuthResponse(false, "Invalid password");
        }

        return new AuthResponse(true, "Login Successful");
    }

    public AuthResponse register(RegisterRequest dto) {
        if (userRepository.existsByEmail(dto.email())) {
            return new AuthResponse(false, "Email already exists");
        }
        if (!dto.password().equals(dto.secondPassword())) {
            return new AuthResponse(false, "Passwords do not match");
        }

        String encodedPassword = passwordEncoder.encode(dto.password());
        userRepository.save(new User(dto.email(), encodedPassword));

        return new AuthResponse(true, "Register Successful");
    }

    public User getCurrentUser() {
        // Возвращаем первого пользователя в базе (для теста)
        return userRepository.findAll().get(0);
    }

}
