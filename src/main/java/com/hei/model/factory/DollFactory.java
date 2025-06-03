package com.hei.model.factory;

import com.hei.model.LittleDoll;
import com.hei.model.MiddleDoll;
import com.hei.model.Toy;

public class DollFactory implements ToyFactory{

    @Override
    public Toy makeForKids() {
        return new LittleDoll();
    }

    @Override
    public Toy makeForChild() {
        return new MiddleDoll();
    }
}
