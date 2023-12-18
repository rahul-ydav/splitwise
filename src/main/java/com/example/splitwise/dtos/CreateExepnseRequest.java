package com.example.splitwise.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateExepnseRequest {
    private String description;
    private Double amount;
    @Builder.Default
    private List<Long> userIds = new ArrayList<>();
}
