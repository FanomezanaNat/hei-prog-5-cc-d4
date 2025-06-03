package com.hei.model.factory;

import com.hei.model.Toy;

public interface ToyFactory {

    Toy makeForKids();

    Toy makeForChild();
}
