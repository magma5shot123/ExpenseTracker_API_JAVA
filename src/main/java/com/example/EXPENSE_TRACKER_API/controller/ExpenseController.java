package com.example.EXPENSE_TRACKER_API.controller;

import com.example.EXPENSE_TRACKER_API.dto.expense.CreateExpenseRequest;
import com.example.EXPENSE_TRACKER_API.dto.expense.ExpenseResponse;
import com.example.EXPENSE_TRACKER_API.dto.expense.UpdateExpenseRequest;
import com.example.EXPENSE_TRACKER_API.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/create")
    public ExpenseResponse create(@Valid @RequestBody CreateExpenseRequest dto) {
        return expenseService.createExpense(dto);
    }

    @GetMapping("/get/{id}")
    public ExpenseResponse getExpenses(@PathVariable Long id) {
        return expenseService.getExpense(id);
    }

    @PutMapping("/update/{id}")
    public ExpenseResponse update(@Valid @RequestBody UpdateExpenseRequest dto, @PathVariable int id) {
        return expenseService.updateExpense(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@Valid @PathVariable Long id) {
        expenseService.deleteExpense(id);
    }

}
