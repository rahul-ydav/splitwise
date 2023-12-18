package com.example.splitwise.commands;

import com.example.splitwise.controllers.ExpenseController;
import com.example.splitwise.dtos.CreateUserExpenseRequest;
import com.example.splitwise.enums.ExpenseType;
import com.example.splitwise.models.UserExpense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CreateUserExpenseCommand implements Command{

    private ExpenseController expenseController;
    @Override
    public boolean matches(String input) {
        return Command.getCommand(input).equals(Commands.ADD_USER_EXPENSE_COMMAND);
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing add-expense command");
        List<String> tokens = Command.getTokens(input);

        CreateUserExpenseRequest request = CreateUserExpenseRequest.builder()
                .expenseId(Long.valueOf(tokens.get(1)))
                .userId(Long.valueOf(tokens.get(2)))
                .amount(Double.valueOf(tokens.get(3)))
                .type(ExpenseType.valueOf(tokens.get(4)))
                .build();

        UserExpense userExpense = expenseController.addUserExpense(request);

        System.out.println("Expense added having id: "+userExpense.getId());
    }
}
