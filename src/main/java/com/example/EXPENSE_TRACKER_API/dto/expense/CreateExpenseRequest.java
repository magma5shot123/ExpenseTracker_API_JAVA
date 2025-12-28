package com.example.EXPENSE_TRACKER_API.dto.expense;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateExpenseRequest(

        @NotBlank(message = "Title can't be blank")
        String title,

        @NotNull(message = "Amount can't be null")
        BigDecimal amount,

        @NotNull(message = "Date can't be null")
        LocalDate date,

        String category,

        String description
) {
}
