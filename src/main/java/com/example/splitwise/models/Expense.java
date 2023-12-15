package com.example.splitwise.models;

import com.example.splitwise.enums.ExpenseStatus;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expense extends BaseModel {
    private String description;
    private double amount;
    @OneToMany(mappedBy = "expense")
    private List<UserExpense> paidBy;
    @OneToMany(mappedBy = "expense")
    private List<UserExpense> owedBy;

    @Enumerated
    private ExpenseStatus status;
}
