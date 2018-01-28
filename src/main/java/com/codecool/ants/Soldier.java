package com.codecool.ants;

public class Soldier extends Ant {

    private Direction direction;

    public Soldier(int x, int y, Direction direction) {
        super(x, y);
        this.direction = direction;
    }

    @Override
    public void step() {
        moveTo(direction);
        direction = direction.turnRight();
    }
}
