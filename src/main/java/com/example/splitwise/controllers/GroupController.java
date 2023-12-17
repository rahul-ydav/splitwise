package com.example.splitwise.controllers;

import org.springframework.stereotype.Controller;

import com.example.splitwise.dtos.CreateGroupRequest;
import com.example.splitwise.models.Group;
import com.example.splitwise.services.GroupService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class GroupController {
    private GroupService groupService;
    
    public Group createGroup(CreateGroupRequest request) {
        return groupService.createGroup(request);
    }
}
