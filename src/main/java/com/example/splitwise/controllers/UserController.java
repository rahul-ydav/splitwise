package com.example.splitwise.controllers;

import com.example.splitwise.dtos.CreateUserDto;
import com.example.splitwise.models.User;
import com.example.splitwise.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class UserController {

    private UserService userService;
    public User createUser(CreateUserDto request){

        User user = request.toUser();
        return userService.createUser(user);
    }
}
