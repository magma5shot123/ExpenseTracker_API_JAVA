package com.example.EXPENSE_TRACKER_API.dto.expense;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateExpenseRequest(
        Long id,
        String title,
        BigDecimal amount,
        LocalDate date,
        String category,
        String description
) {
}
