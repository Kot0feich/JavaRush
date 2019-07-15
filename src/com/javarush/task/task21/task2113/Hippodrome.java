package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    void run () throws Exception{
        for (int i=0;i<100;i++) {

            move();
            print();
            Thread.sleep(200);
        }

    }

    void move () {
        for (int i=0;i<horses.size();i++) {
            horses.get(i).move();
        }
    }

    void print () {
        for (int i=0;i<horses.size();i++) {
            horses.get(i).print();
        }
        for (int i=0;i<10;i++) System.out.println();
    }
    static Hippodrome game;

    public Horse getWinner () {
        double max=horses.get(0).distance;
        int horceIndex=0;
        for(int i=1;i<horses.size();i++) {
            if (max<horses.get(i).distance) {
                max = horses.get(i).distance;
                horceIndex=i;
            }
        }
        return horses.get(horceIndex);
    }

    public void printWinner () {
        System.out.println("Winner is " + getWinner().name + "!");
    }
    public static void main(String[] args) throws Exception {
        game = new Hippodrome(new ArrayList<Horse>());
        game.horses.add(new Horse("horce1",3, 0));
        game.horses.add(new Horse("horce2",3,0));
        game.horses.add(new Horse("horce3",3,0));
        game.run();
        game.printWinner();

    }
}
