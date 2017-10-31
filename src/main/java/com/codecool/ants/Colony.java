package com.codecool.ants;

import java.util.ArrayList;
import java.util.List;

public class Colony {

    public static final int ROUNDS = 30;
    private List<Ant> ants = new ArrayList<>();

    public static void main(String[] args) {
        Colony colony = new Colony();
        colony.createAnts(3, 2, 2);
        for (int time = 0; time < ROUNDS; time++) {
            System.out.println(colony);
            colony.step();
        }
    }

    public void step() {
        for (Ant ant : ants) {
            ant.step();
        }
    }

    public void createAnts(int noOfWorkers, int noOfSoldiers, int noOfDrones) {
        Queen queen = new Queen(0, 0);
        ants.add(queen);
        for (int i = 0; i < noOfWorkers; i++) {
            ants.add(new Worker());
        }
        for (int i = 0; i < noOfSoldiers; i++) {
            ants.add(new Soldier());
        }
        for (int i = 0; i < noOfDrones; i++) {
            ants.add(new Drone(queen));
        }
    }

    @Override
    public String toString() {
        return ants.toString();
    }

}
