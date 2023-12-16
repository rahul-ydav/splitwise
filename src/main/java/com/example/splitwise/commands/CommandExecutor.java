package com.example.splitwise.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public void removeCommand(Command command) {
        this.commands.remove(command);
    }

    public void execute(String input) {
        for (Command command : commands) {
            if (command.matches(input)) {
                command.execute(input);
                break;
            }
            
        }
    }
}
