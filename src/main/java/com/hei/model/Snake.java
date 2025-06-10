package com.hei.model;

import lombok.Builder;
import lombok.Data;

import java.util.LinkedList;
import java.util.Objects;

@Data

public class Snake {
    private LinkedList<Point> body;
    private Direction direction;
    private Point position;
    private boolean grow;

    @Builder
    public Snake(Direction direction, Point position) {
        this.direction = direction;
        this.position = position;
        this.grow = false;
        this.body = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            body.add(new Point(position.getX() - i * direction.dx, position.getY() - i * direction.dy));
        }

    }

    public Point peekNextHead() {
        Point head = body.peekLast();
        return new Point(Objects.requireNonNull(head).getX() + direction.dx, head.getY() + direction.dy);
    }

    public Point move() {
        Point next = peekNextHead();
        body.addLast(next);
        if (!grow) {
            body.removeFirst();
        } else {
            grow = false;
        }
        return next;
    }

    public boolean hitsWall(int width, int height) {
        Point head = body.peekLast();
        return Objects.requireNonNull(head).getX() < 0 || head.getX() >= width || head.getY() < 0 || head.getY() >= height;
    }

    public boolean hitsSelf() {
        Point head = body.peekLast();
        return body.stream().filter(p -> p.equals(head)).count() > 1;
    }
}


