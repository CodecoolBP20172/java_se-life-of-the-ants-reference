package com.codecool.ants;

public class Soldier extends Ant {

    private Direction direction = Direction.getRandomDirection();

    @Override
    public void step() {
        moveTo(direction);
        direction = direction.turnRight();
    }
}
