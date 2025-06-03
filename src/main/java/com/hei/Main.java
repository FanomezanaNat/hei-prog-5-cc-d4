package com.hei;

import com.hei.model.factory.AbstractToyFactory;
import com.hei.model.factory.DollFactory;

public class Main {
    public static void main(String[] args) {
        var toy = AbstractToyFactory.makeToy(new DollFactory(), "child");
        System.out.println(toy.play());
    }
}
