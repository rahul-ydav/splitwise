package com.example.splitwise.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.splitwise.dtos.CreateGroupRequest;
import com.example.splitwise.models.Group;
import com.example.splitwise.models.User;
import com.example.splitwise.repositories.GroupRepositroy;

@Service
public class GroupService {
    private UserService userService;
    private GroupRepositroy groupRepository;

    public Group createGroup(CreateGroupRequest request) {
        User createdBy = userService.getUser(request.getCreatedBy());
        List<User> members = userService.getUsers(request.getMemberIds());
        Group group = Group.builder().groupName(request.getName()).createdBy(createdBy).members(members).admins(List.of(createdBy)).build();
        return groupRepository.save(group);
    }

    public Group getGroup(Long groupId) {
        return groupRepository.findById(groupId).orElse(null);
    }
}
