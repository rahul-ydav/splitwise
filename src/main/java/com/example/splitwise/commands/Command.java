package com.example.splitwise.commands;

import java.util.Arrays;
import java.util.List;

public interface Command {
    boolean matches(String input);
    void execute(String input);
    
    static String getCommand(String input) {
        List<String> tokens = getTokens(input);
        return tokens.get(0);
    }

    static List<String> getTokens(String input){
        return Arrays.stream(input.split(" ")).toList();
    }
} 