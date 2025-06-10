package com.hei.model.strategy;

import com.hei.model.Direction;

public interface MoveStrategy {
    String computeNextPosition(String direction);
}
