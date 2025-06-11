package com.hei.model.state;


import com.hei.model.Game;

import static com.hei.model.Game.HEIGHT;
import static com.hei.model.Game.WIDTH;

public class RunningState implements GameState {

    @Override
    public void handler(Game game) {
        game.render();
        game.update();

        if (game.getSnake().hitsWall(WIDTH, HEIGHT) || game.getSnake().hitsSelf()) {
            game.setState(new GameOverState());
        }
    }
}
