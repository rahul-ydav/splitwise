package com.example.splitwise.commands;

public class CreateUserCommand implements Command {

    @Override
    public boolean matches(String input) {
        return getCommand(input).equals(Commands.REGISTER_USER_COMMAND);      
    }

    @Override
    public void execute(String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}
