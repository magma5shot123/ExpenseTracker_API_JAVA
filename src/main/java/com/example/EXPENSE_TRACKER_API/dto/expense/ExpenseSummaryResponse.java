package com.example.EXPENSE_TRACKER_API.dto.expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public record ExpenseSummaryResponse(

        BigDecimal totalExpenses,
        Map<String, BigDecimal> byCategory,
        LocalDate startDate,
        LocalDate endDate
) {
}
