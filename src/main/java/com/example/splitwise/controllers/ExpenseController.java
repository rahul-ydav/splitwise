package com.example.splitwise.controllers;

import org.springframework.stereotype.Controller;

import com.example.splitwise.dtos.CreateExepnseRequest;
import com.example.splitwise.models.Expense;
import com.example.splitwise.services.ExpenseService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ExpenseController {
    
    private ExpenseService expenseService;
    
    public Expense createExepnse(CreateExepnseRequest request) {
        return expenseService.createExpense(request);
    }
}
