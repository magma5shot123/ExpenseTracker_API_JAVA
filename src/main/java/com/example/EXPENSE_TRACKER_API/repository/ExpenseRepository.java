package com.example.EXPENSE_TRACKER_API.repository;

import com.example.EXPENSE_TRACKER_API.entity.Expense;
import com.example.EXPENSE_TRACKER_API.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUser(User user);

    Optional<Expense> findById(Long id);
}
