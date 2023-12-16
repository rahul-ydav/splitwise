package com.example.splitwise.commands;

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
