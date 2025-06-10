package com.hei.model.factory;

import com.hei.model.Point;
import com.hei.model.Snake;
import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodFactory {
    private static Random random = new Random();

    public static Food makeFood(Snake snake, int height, int width) {
        Point coordinate;
        do {
            coordinate = new Point(random.nextInt(height), random.nextInt(width));
        } while (snake.getBody().contains(coordinate));

        return new Food(coordinate);

    }
}
