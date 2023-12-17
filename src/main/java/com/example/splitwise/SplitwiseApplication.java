package com.example.splitwise;

import com.example.splitwise.commands.Command;
import com.example.splitwise.commands.CommandExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseApplication implements CommandLineRunner {
    private CommandExecutor commandExecutor;
    private Scanner scanner;

    public SplitwiseApplication(CommandExecutor commandExecutor, List<Command> command) {
        this.scanner = new Scanner(System.in);
        this.commandExecutor = commandExecutor;
        this.commandExecutor.addCommand(command);
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {

            System.out.println("Enter input:");
            String input = scanner.nextLine();
            System.out.println("User entered: " + input);

            commandExecutor.execute(input);
        }
    }
}
