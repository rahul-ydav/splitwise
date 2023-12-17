package com.example.splitwise.commands;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(List<Command> commands) {
        this.commands.addAll(commands);
    }

    public void removeCommand(Command command) {
        this.commands.remove(command);
    }

    public void execute(String input) {
        boolean validCommand = false;
        for (Command command : commands) {
            if (command.matches(input)) {
                command.execute(input);
                validCommand = true;
                break;
            }
        }
        if(!validCommand) System.out.println("Invalid Command");
    }
}
