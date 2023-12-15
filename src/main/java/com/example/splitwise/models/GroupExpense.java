package com.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GroupExpense extends BaseModel{
    @ManyToOne
    private Group group;

    @OneToOne
    private Expense expense;
}
