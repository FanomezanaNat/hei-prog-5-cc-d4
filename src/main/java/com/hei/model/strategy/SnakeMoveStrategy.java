package com.hei.model.strategy;

import java.util.Scanner;

import static com.hei.model.Direction.*;
import static java.lang.System.in;
import static java.lang.System.out;


public class SnakeMoveStrategy implements MoveStrategy {
    private final Scanner scanner = new Scanner(in);

    @Override
    public String computeNextPosition(String direction) {
        out.print("Direction (WASD,Q to quit Enter to keep): ");
        String input = scanner.nextLine().trim().toUpperCase();

        if ("Q".equalsIgnoreCase(input)) {
            out.println("Quitting game...");
            System.exit(0);
        }

        return switch (input) {
            case "W" -> UP.toString();
            case "S" -> DOWN.toString();
            case "A" -> LEFT.toString();
            case "D" -> RIGHT.toString();
            default -> direction;
        };
    }
}
