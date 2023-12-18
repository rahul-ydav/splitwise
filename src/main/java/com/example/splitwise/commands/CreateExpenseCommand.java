package com.example.splitwise.commands;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.splitwise.controllers.ExpenseController;
import com.example.splitwise.dtos.CreateExepnseRequest;
import com.example.splitwise.models.Expense;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateExpenseCommand implements Command {

    private ExpenseController expenseController;

    @Override
    public boolean matches(String input) {
        return Command.getCommand(input).equals(Commands.CREATE_EXPENSE_COMMAND);
    }

    @Override
    public void execute(String input) {
        List<String> tokens = Command.getTokens(input);

        List<Long> userIds = Arrays.stream(tokens.get(3).split(","))
            .map(Long::valueOf)
            .toList();

        CreateExepnseRequest request = CreateExepnseRequest.builder()
            .description(tokens.get(1))
            .amount(Double.valueOf(tokens.get(2)))
            .userIds(userIds)
                .build();

        Expense expense = expenseController.createExepnse(request);
        System.out.println("Expense created with id: " + expense.getId());
    }
    
}
