package com.example.splitwise.services;

import com.example.splitwise.models.Expense;
import com.example.splitwise.models.Group;
import com.example.splitwise.models.GroupExpense;
import com.example.splitwise.repositories.GroupExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupExpenseService {
    private GroupExpenseRepository groupExpenseRepository;
    public GroupExpense createGroupExpense(GroupExpense groupExepnse) {
        return groupExpenseRepository.save(groupExepnse);
    }
}
