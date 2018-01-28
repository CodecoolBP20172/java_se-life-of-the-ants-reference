package com.codecool.ants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Colony {

    private static Random random = new Random();
    private static final int ROUNDS = 6;
    private int xRange, yRange;
    private Queen queen;

    private List<Ant> ants = new ArrayList<>();

    public static void main(String[] args) {
        Colony colony = new Colony(100, 100);
        colony.createAnts(0, 1, 0);
        for (int time = 0; time < ROUNDS; time++) {
            System.out.println(colony);
            colony.step();
        }
    }

    private static int getNumberInRange(int range) {
        return random.nextInt(range) - range / 2;
    }

    public Colony(int xRange, int yRange) {
        this.xRange = xRange;
        this.yRange = yRange;
    }

    public void step() {
        for (Ant ant : ants) {
            ant.step();
        }
    }

    public void addAnt(Ant ant) {
        if (ant instanceof Queen) {
            if (queen == null)
                queen = (Queen) ant;
            else {
                System.out.println("There is already a Queen in the Colony");
                return;
            }
        }
        ants.add(ant);
    }

    public void createAnts(int noOfWorkers, int noOfSoldiers, int noOfDrones) {
        addAnt(new Queen(0, 0));
        for (int i = 0; i < noOfWorkers; i++) {
            addAnt(new Worker(getNumberInRange(xRange), getNumberInRange(yRange)));
        }
        for (int i = 0; i < noOfSoldiers; i++) {
            addAnt(new Soldier(getNumberInRange(xRange), getNumberInRange(yRange), Direction.getRandomDirection()));
        }
        for (int i = 0; i < noOfDrones; i++) {
            addAnt(new Drone(getNumberInRange(xRange), getNumberInRange(yRange), queen));
        }
    }

    @Override
    public String toString() {
        return ants.toString();
    }

}
