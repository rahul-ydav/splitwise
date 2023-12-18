package com.example.splitwise.services;

import java.util.List;

import com.example.splitwise.dtos.CreateGroupExpenseRequest;
import com.example.splitwise.dtos.CreateUserExpenseRequest;
import com.example.splitwise.exceptions.GroupNotFoundException;
import com.example.splitwise.models.*;
import com.example.splitwise.repositories.GroupRepositroy;
import org.springframework.stereotype.Service;

import com.example.splitwise.dtos.CreateExepnseRequest;
import com.example.splitwise.enums.ExpenseStatus;
import com.example.splitwise.repositories.ExepnseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExpenseService {

    private UserService userService;
    private UserExpenseService userExpenseService;
    private GroupExpenseService groupExpenseService;
    private ExepnseRepository exepnseRepository;
    private GroupService groupService;

    
    public Expense createExpense(CreateExepnseRequest request) {
        List<User> users = userService.getUsers(request.getUserIds());

        Expense expense = Expense.builder()
            .amount(request.getAmount())
            .description(request.getDescription())
            .status(ExpenseStatus.PENDING)
            .users(users)
            .build();
        
        return exepnseRepository.save(expense);
    }

    public UserExpense addUserExpense(CreateUserExpenseRequest request) {

        Expense expense = exepnseRepository.findById(request.getExpenseId()).orElseThrow(() -> new IllegalArgumentException("Expense not found"));

        User user = userService.getUser(request.getUserId());

        UserExpense userExpense = UserExpense.builder()
                .expense(expense)
                .user(user)
                .amount(request.getAmount())
                .expenseType(request.getType())
                .build();

        return userExpenseService.createUserExpense(userExpense);
    }

    public GroupExpense createGroupExpense(CreateGroupExpenseRequest request) {
        List<User> users = userService.getUsers(request.getUserIds());
        Group group = groupService.getGroup(request.getGroupId());
        if(group==null){
            throw new GroupNotFoundException(request.getGroupId());
        }
        Expense expense = Expense.builder()
                .description(request.getDescription())
                .amount(request.getAmount())
                .users(users)
                .status(ExpenseStatus.PENDING)
                .build();

        exepnseRepository.save(expense);

        GroupExpense groupExpense = GroupExpense.builder()
                .expense(expense)
                .group(group)
                .build();

        return groupExpenseService.createGroupExpense(groupExpense);
    }
}
