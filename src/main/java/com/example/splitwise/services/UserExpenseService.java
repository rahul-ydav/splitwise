package com.example.splitwise.services;

import com.example.splitwise.models.UserExpense;
import com.example.splitwise.repositories.UserExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserExpenseService {
    private UserExpenseRepository userExpenseRepository;

    public UserExpense createUserExpense(UserExpense userExpense) {
        return userExpenseRepository.save(userExpense);
    }
}
