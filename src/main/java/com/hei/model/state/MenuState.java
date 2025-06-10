package com.hei.model.state;

import com.hei.model.Game;

import java.util.Scanner;

public class MenuState implements GameState {
    @Override
    public void handler(Game game) {
        System.out.println("=== MENU ===");
        System.out.println("Appuyez sur 'Entrée' pour commencer...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        game.initGame();
        game.setState(new RunningState());
    }
}
