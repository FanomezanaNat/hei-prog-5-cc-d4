package com.hei.model.state;

import com.hei.model.Game;

import java.util.Scanner;

public class GameOverState implements GameState {
    @Override
    public void handler(Game game) {
        System.out.println("=== GAME OVER ===");
        System.out.println("Score final : " + game.getScore());
        System.out.println("Appuyez sur 'Entrée' pour quitter...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.exit(0);
    }
}
