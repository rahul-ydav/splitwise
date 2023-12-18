package com.example.splitwise.commands;

import java.util.Arrays;
import java.util.List;

import com.example.splitwise.controllers.GroupController;
import com.example.splitwise.dtos.CreateGroupRequest;
import com.example.splitwise.models.Group;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CreateGroupCommand implements Command {

    GroupController groupController;

    @Override
    public boolean matches(String input) {
        return Command.getCommand(input).equals(Commands.CREATE_GROUP_COMMAND);
    }

    @Override
    public void execute(String input) {
        List<String> tokens = Command.getTokens(input);
        List<Long> memberIds = Arrays.stream(tokens.get(3).split(",")).map(Long::valueOf).toList();

        CreateGroupRequest request = CreateGroupRequest.builder()
            .name(tokens.get(1))
            .createdBy(Long.valueOf(tokens.get(2)))
            .memberIds(memberIds)
                .build();
            
        Group group = groupController.createGroup(request);
        System.out.println("Created group with id: " + group.getId());
    }
    
}
