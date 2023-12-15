package com.example.splitwise.models;

import com.example.splitwise.enums.ExpenseType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserExpense extends BaseModel {
    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;
    private double amount;
    private String note;
    @Enumerated
    private ExpenseType expenseType;
}
