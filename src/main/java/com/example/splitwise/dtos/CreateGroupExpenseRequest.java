package com.example.splitwise.dtos;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class CreateGroupExpenseRequest {
    private String description;
    private Double amount;
    private Long groupId;
    private List<Long> userIds = new ArrayList<>();
}
