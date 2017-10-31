package com.codecool.ants;

public class Queen extends Ant {

    private static final int MATING_PAUSE_MINIMUM = 30;
    private static final int MATING_PAUSE_MAXIMUM = 60;
    private int counterAfterMating = 0;

    public Queen(int x, int y) {
        super(x, y);
    }

    @Override
    public void step() {
        if (counterAfterMating > 0) {
            counterAfterMating--;
        }
    }

    public boolean isInMatingMood() {
        return counterAfterMating == 0;
    }

    public void letsMate() {
        counterAfterMating = random.nextInt(MATING_PAUSE_MAXIMUM - MATING_PAUSE_MINIMUM) + MATING_PAUSE_MINIMUM;
    }

}
