package com.hei.model;

import com.hei.model.factory.FoodFactory;
import com.hei.model.state.GameState;
import com.hei.model.state.MenuState;
import com.hei.model.strategy.SnakeMoveStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

import static com.hei.model.Direction.RIGHT;
import static java.util.Arrays.fill;

@Getter
@Setter
public class Game {

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;

    private Snake snake;
    private Point positionFood;
    private int score;
    private GameState state;

    private final Scanner scanner = new Scanner(System.in);
    private final SnakeMoveStrategy snakeMoveStrategy = new SnakeMoveStrategy();

    public Game() {
        this.state = new MenuState();
    }

    public void start() {
        while (true) {
            state.handler(this);
        }
    }

    public void initGame() {
        snake = Snake.builder()
                .direction(RIGHT)
                .position(new Point(4, 5))
                .build();

        positionFood = FoodFactory.makeFood(snake, HEIGHT, WIDTH).getPosition();
        score = 0;
    }

    public void render() {
        char[][] board = new char[HEIGHT][WIDTH];
        for (int y = 0; y < HEIGHT; y++)
            fill(board[y], '.');

        for (Point point : snake.getBody()) {
            var x = point.getX();
            var y = point.getY();
            if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT)
                board[y][x] = '*';
        }
        board[positionFood.getY()][positionFood.getX()] = '@';

        for (char[] row : board) {
            for (char c : row) System.out.print(c + " ");
            System.out.println();
        }
        System.out.println("Score : " + score);
    }

    public void update() {
        var snakeMovement = snakeMoveStrategy.computeNextPosition(snake.getDirection().toString());
        var direction = Direction.valueOf(snakeMovement);

        if (!direction.isOpposite(snake.getDirection()))
            snake.setDirection(direction);

        Point nextHead = snake.move();

        if (nextHead.equals(positionFood)) {
            snake.setGrow(true);
            score++;
            positionFood = FoodFactory.makeFood(snake, HEIGHT, WIDTH).getPosition();
        }
    }
}
