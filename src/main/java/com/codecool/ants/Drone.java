package com.codecool.ants;

public class Drone extends Ant {

    private static final int MATING_DISTANCE = 3;
    private static final int MATING_DURATION = 10;
    private static final int KICKOFF_DISTANCE = 100;
    private Queen queen;
    private int counterAfterMating;

    public Drone(int x, int y, Queen queen) {
        super(x, y);
        this.queen = queen;
    }

    @Override
    public void step() {
        if (counterAfterMating > 0) {
            counterAfterMating--;
            if (counterAfterMating == 0)
                getKickedOff();
            return;
        }
        if (distanceFrom(queen) < MATING_DISTANCE) {
            tryMating();
        } else {
            moveTo(directionTo(queen));
        }
    }

    private void tryMating() {
        if (queen.isInMatingMood())
            letsMate();
        else
            getKickedOff();
    }

    private void letsMate() {
        queen.letsMate();
        System.out.println("HALLELUJAH!");
        counterAfterMating = MATING_DURATION;
    }

    private void getKickedOff() {
        System.out.println("D'OH...");
        x = random.nextInt(KICKOFF_DISTANCE) * getRandomSign();
        y = (KICKOFF_DISTANCE - Math.abs(x)) * getRandomSign();
    }

    private static int getRandomSign() {
        return random.nextInt(2) > 0 ? 1 : -1;
    }

}
