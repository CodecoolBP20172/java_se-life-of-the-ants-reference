package com.codecool.ants;

import java.util.Random;

public abstract class Ant {

    static Random random = new Random();
    int x, y;

    public Ant(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distanceFromOrigo() {
        return Math.abs(x) + Math.abs(y);
    }

    public int distanceFrom(Ant other) {
        return Math.abs(x - other.x) + Math.abs(y - other.y);
    }

    public Direction directionTo(Ant other) {
        if (Math.abs(x - other.x) > Math.abs(y - other.y)) {
            return x > other.x ? Direction.West : Direction.East;
        } else {
            return y > other.y ? Direction.South: Direction.North;
        }
    }

    public void moveTo(Direction direction) {
        x += direction.getDeltaX();
        y += direction.getDeltaY();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (" + x + "," + y + ")";
    }

    public abstract void step();

}
