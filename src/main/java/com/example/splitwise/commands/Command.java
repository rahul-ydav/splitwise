package com.example.splitwise.commands;

import java.util.Arrays;
import java.util.List;

public interface Command {
    boolean matches(String input);
    void execute(String input);
    
    default String getCommand(String input) {
        List<String> tokens = Arrays.stream(input.split(" ")).toList();
        return tokens.get(0);
    }
} 