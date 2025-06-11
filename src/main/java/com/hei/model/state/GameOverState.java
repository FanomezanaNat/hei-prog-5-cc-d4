package com.hei.model.state;

import com.hei.model.Game;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class GameOverState implements GameState {
    @Override
    public void handler(Game game) {
        out.println("=== GAME OVER ===");
        out.println("Final score : " + game.getScore());
        out.println("Touch on any touch to quit ...");
        Scanner scanner = new Scanner(in);
        scanner.nextLine();
        System.exit(0);
    }
}
