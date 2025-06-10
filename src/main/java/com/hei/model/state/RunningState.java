package com.hei.model.state;


import com.hei.model.Game;

public class RunningState implements GameState {

    @Override
    public void handler(Game game) {
        game.render();
        game.update();

        if (game.getSnake().hitsWall(Game.WIDTH, Game.HEIGHT) || game.getSnake().hitsSelf()) {
            game.setState(new GameOverState());
        }
    }
}
