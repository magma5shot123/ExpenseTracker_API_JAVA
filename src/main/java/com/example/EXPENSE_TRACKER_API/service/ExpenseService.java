package com.example.EXPENSE_TRACKER_API.service;

import com.example.EXPENSE_TRACKER_API.dto.expense.CreateExpenseRequest;
import com.example.EXPENSE_TRACKER_API.dto.expense.ExpenseResponse;
import com.example.EXPENSE_TRACKER_API.dto.expense.UpdateExpenseRequest;
import com.example.EXPENSE_TRACKER_API.entity.Expense;
import com.example.EXPENSE_TRACKER_API.entity.User;
import com.example.EXPENSE_TRACKER_API.repository.ExpenseRepository;
import com.example.EXPENSE_TRACKER_API.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final AuthService authService;

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository,  AuthService authService) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.authService = authService;
    }

    public ExpenseResponse createExpense(CreateExpenseRequest dto) {
        Expense expense = new Expense();
        User user = getCurrentUser();

        expense.setUser(user);
        expense.setAmount(dto.amount());
        expense.setCategory(dto.category());
        expense.setDescription(dto.description());
        expense.setDate(dto.date());
        expense.setTitle(dto.title());

        Expense savedExpense = expenseRepository.save(expense);
        return mapToResponse(savedExpense);
    }

    public void deleteExpense(Long id) {
        User currentUser = getCurrentUser();
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
        if (!expense.getUser().equals(currentUser)) {
            throw new RuntimeException("Not authorized to delete expense");
        }
        expenseRepository.delete(expense);
    }

    public ExpenseResponse updateExpense(UpdateExpenseRequest dto) {
        User currentUser = getCurrentUser();
        Expense expense = expenseRepository.findById(dto.id()).orElseThrow(() -> new RuntimeException("Expense not found"));
        if (!expense.getUser().equals(currentUser)) {
            throw new RuntimeException("Not authorized to delete expense");
        }

        if (!Objects.equals(dto.amount(), expense.getAmount())) {
            expense.setAmount(dto.amount());
        }
        if (!dto.category().equals(expense.getCategory())) {
            expense.setCategory(dto.category());
        }
        if (!dto.description().equals(expense.getDescription())) {
            expense.setDescription(dto.description());
        }
        if (dto.date() != expense.getDate()) {
            expense.setDate(expense.getDate());
        }
        if (!dto.title().equals(expense.getTitle())) {
            expense.setTitle(dto.title());
        }
        Expense savedExpense = expenseRepository.save(expense);
        return mapToResponse(savedExpense);
    }

    public ExpenseResponse getExpense(Long expenseId) {
        User currentUser = getCurrentUser();
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        if (!expense.getUser().equals(currentUser)) {
            throw new RuntimeException("Not authorized to delete expense");
        }
        return  mapToResponse(expense);
    }





    private ExpenseResponse mapToResponse(Expense expense) {
        return new ExpenseResponse(
                expense.getId(),
                expense.getTitle(),
                expense.getAmount(),
                expense.getDate(),
                expense.getCategory(),
                expense.getDescription()
        );
    }

    private User getCurrentUser() {
        return authService.getCurrentUser();
    }
}
