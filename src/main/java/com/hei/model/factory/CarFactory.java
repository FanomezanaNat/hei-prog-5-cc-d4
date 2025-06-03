package com.hei.model.factory;

import com.hei.model.LittleCar;
import com.hei.model.MiddleCar;
import com.hei.model.Toy;

public class CarFactory implements ToyFactory{


    @Override
    public Toy makeForKids() {
        return new LittleCar();
    }

    @Override
    public Toy makeForChild() {
        return new MiddleCar();
    }
}
