package com.codecool.ants;

public class Worker extends Ant {

    @Override
    public void step() {
        moveTo(Direction.getRandomDirection());
    }

}
