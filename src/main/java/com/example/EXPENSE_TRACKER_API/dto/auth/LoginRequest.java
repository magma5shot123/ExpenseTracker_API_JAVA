package com.example.EXPENSE_TRACKER_API.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

public record LoginRequest (

        @Email (message = "Invalid email format")
        @NotBlank(message = "Email must not be blank")
        String email,

        @NotBlank(message = "Password must not be blank")
        @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
        String password

) {
}
