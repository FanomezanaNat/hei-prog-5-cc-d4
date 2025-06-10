package com.hei.model.strategy;

import java.util.Scanner;

import static com.hei.model.Direction.*;


public class SnakeMoveStrategy implements MoveStrategy {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String computeNextPosition(String direction) {
        System.out.print("Direction (WASD, Enter to keep): ");
        String input = scanner.nextLine().trim().toUpperCase();

        return switch (input) {
            case "W" -> UP.toString();
            case "S" -> DOWN.toString();
            case "A" -> LEFT.toString();
            case "D" -> RIGHT.toString();
            default -> direction;
        };
    }
}
