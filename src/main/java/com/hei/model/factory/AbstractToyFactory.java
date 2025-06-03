package com.hei.model.factory;

import com.hei.model.Toy;

public class AbstractToyFactory {
    public static Toy makeToy(ToyFactory factory, String type) {
        return switch (type.toLowerCase()) {
            case "child" -> factory.makeForChild();
            case "kids" -> factory.makeForKids();
            default -> throw new IllegalStateException("Unexpected value: " + type.toLowerCase());
        };
    }

}
