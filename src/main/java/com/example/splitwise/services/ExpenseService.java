package com.example.splitwise.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.splitwise.dtos.CreateExepnseRequest;
import com.example.splitwise.models.Expense;
import com.example.splitwise.models.User;
import com.example.splitwise.repositories.ExepnseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExpenseService {

    private UserService userService;
    private ExepnseRepository exepnseRepository;
    
    public Expense createExpense(CreateExepnseRequest request) {
        List<User> users = userService.getUsers(request.getUserIds());

        Expense expense = Expense.builder()
            .amount(request.getAmount())
            .description(request.getDescription())
            .users(users)
                .build();
        
        return exepnseRepository.save(expense);
    }
}
