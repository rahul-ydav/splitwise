package com.example.splitwise.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateGroupRequest {
    private String name;
    private Long createdBy;
    @Builder.Default
    private List<Long> memberIds = new ArrayList<>();
}
