package com.hei.model.factory;

import com.hei.model.Point;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Food {
    private Point position;
}
