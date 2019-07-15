package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class FemaleFactory implements AbstractFactory {
    public Human getPerson (int age) {
        KidGirl kidGirl = new KidGirl();
        TeenGirl teenGirl = new TeenGirl();
        if (age <= kidGirl.MAX_AGE) return kidGirl;
        if (age > kidGirl.MAX_AGE && age <= teenGirl.MAX_AGE) return teenGirl;
        else return new Woman();

    }
}
