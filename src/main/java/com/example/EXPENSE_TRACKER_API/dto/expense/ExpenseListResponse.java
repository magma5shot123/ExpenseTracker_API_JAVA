package com.example.EXPENSE_TRACKER_API.dto.expense;

import java.util.List;

public record ExpenseListResponse(
        List<ExpenseResponse> expenses,
        int totalCount
) {
}
