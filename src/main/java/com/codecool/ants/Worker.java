package com.codecool.ants;

public class Worker extends Ant {

    public Worker(int x, int y) {
        super(x, y);
    }

    @Override
    public void step() {
        moveTo(Direction.getRandomDirection());
    }

}
