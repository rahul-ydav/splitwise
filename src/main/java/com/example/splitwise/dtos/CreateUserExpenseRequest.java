package com.example.splitwise.dtos;

import com.example.splitwise.enums.ExpenseType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateUserExpenseRequest {
    private Long expenseId;
    private Long userId;
    private Double amount;
    private ExpenseType type;
}
