package com.codecool.ants;

import java.util.Random;

public enum Direction {
    North(0, 1), East(1, 0), South(0, -1), West(-1, 0);

    private static Random random = new Random();
    private static int size = Direction.values().length;
    private int deltaX, deltaY;

    Direction(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public static Direction getRandomDirection() {
        return Direction.values()[random.nextInt(size)];
    }

    public Direction turnRight() {
        int ord = this.ordinal() + 1;
        if (ord == size)
            ord = 0;
        return Direction.values()[ord];
    }

    public Direction turnLeft() {
        int ord = this.ordinal() - 1;
        if (ord < 0)
            ord = size - 1;
        return Direction.values()[ord];
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }
}
