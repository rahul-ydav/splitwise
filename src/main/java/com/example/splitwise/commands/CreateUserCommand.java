package com.example.splitwise.commands;

import com.example.splitwise.controllers.UserController;
import com.example.splitwise.dtos.CreateUserDto;
import com.example.splitwise.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class CreateUserCommand implements Command {

    private UserController userController;

    @Override
    public boolean matches(String input) {
        return Command.getCommand(input).equals(Commands.REGISTER_USER_COMMAND);
    }

    @Override
    // command: register name email password
    public void execute(String input) {

        System.out.println("Executing User create command");
        List<String> tokens = Command.getTokens(input);

        CreateUserDto request = CreateUserDto.builder()
                .name(tokens.get(1))
                .email(tokens.get(2))
                .password(tokens.get(3))
                .build();

        User user = userController.createUser(request);

        System.out.println("User Created having name : " + user.getName());
    }
    
}
