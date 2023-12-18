package com.example.splitwise.controllers;

import com.example.splitwise.dtos.CreateGroupExpenseRequest;
import com.example.splitwise.dtos.CreateUserExpenseRequest;
import com.example.splitwise.models.GroupExpense;
import com.example.splitwise.models.UserExpense;
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

    public UserExpense addUserExpense(CreateUserExpenseRequest request) {
        return expenseService.addUserExpense(request);
    }

    public GroupExpense createGroupExpense(CreateGroupExpenseRequest request){

        return expenseService.createGroupExpense(request);
    }
}
