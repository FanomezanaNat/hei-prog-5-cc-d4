package com.hei.model;

public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);
    public final int dx, dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public boolean isOpposite(Direction other) {
        return (this == UP && other == DOWN)
                || (this == DOWN && other == UP)
                || (this == LEFT && other == RIGHT)
                || (this == RIGHT && other == LEFT);
    }
}
