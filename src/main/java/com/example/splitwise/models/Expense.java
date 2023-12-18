package com.example.splitwise.models;

import com.example.splitwise.enums.ExpenseStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
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

    @ManyToMany
    @Builder.Default
    private List<User> users = new ArrayList<>();
    
    @OneToMany(mappedBy = "expense")
    private List<UserExpense> paidBy;
    
    @OneToMany(mappedBy = "expense")
    private List<UserExpense> owedBy;

    @Enumerated
    private ExpenseStatus status;
}
