package com.hei.model.state;

import com.hei.model.Game;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class MenuState implements GameState {
    @Override
    public void handler(Game game) {
        out.println("=== MENU ===");
        out.println("Welcome ! Click 'Enter' touch to begin...");
        Scanner scanner = new Scanner(in);
        scanner.nextLine();
        game.initGame();
        game.setState(new RunningState());
    }
}
