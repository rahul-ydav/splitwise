package com.example.splitwise.dtos;

import com.example.splitwise.models.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateUserDto {
    private String name;
    private String email;
    private String password;


    // transformation

    public User toUser(){
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
