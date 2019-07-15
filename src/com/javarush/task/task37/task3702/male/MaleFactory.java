package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class MaleFactory implements AbstractFactory {

    public Human getPerson (int age) {
        KidBoy kidBoy = new KidBoy();
        TeenBoy teenBoy = new TeenBoy();
        if (age <= kidBoy.MAX_AGE) return kidBoy;
        if (age > kidBoy.MAX_AGE && age <= teenBoy.MAX_AGE) return teenBoy;
        else return new Man();

    }
}
