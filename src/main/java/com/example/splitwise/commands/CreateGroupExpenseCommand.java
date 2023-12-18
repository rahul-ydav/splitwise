package com.example.splitwise.commands;

import com.example.splitwise.controllers.ExpenseController;
import com.example.splitwise.dtos.CreateGroupExpenseRequest;
import com.example.splitwise.models.GroupExpense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class CreateGroupExpenseCommand implements Command {

    private ExpenseController expenseController;

    @Override
    public boolean matches(String input) {
        return Command.getCommand(input).equals(Commands.CREATE_GROUP_EXPENSE_COMMAND);
    }

    @Override
    public void execute(String input) {
        System.out.println("Creating Group_User_Expenses");
        List<String> tokens = Command.getTokens(input);

        List<Long> allUsers = Arrays.stream(tokens.get(4).split(",")).map(Long::valueOf).toList();

        CreateGroupExpenseRequest  request = CreateGroupExpenseRequest.builder()
                .description(tokens.get(1))
                .amount(Double.valueOf(tokens.get(2)))
                .groupId(Long.valueOf(tokens.get(3)))
                .userIds(allUsers)
                .build();

        GroupExpense groupExpense = expenseController.createGroupExpense(request);

        System.out.println("GroupExpense created with id: "+groupExpense.getId());
    }
}
