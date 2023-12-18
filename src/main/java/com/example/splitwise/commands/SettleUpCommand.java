package com.example.splitwise.commands;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SettleUpCommand implements Command{

    @Override
    public boolean matches(String input) {
        return Command.getCommand(input).equals(Commands.SETTLE_UP_COMMAND);
    }

    @Override
    public void execute(String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}
