package com.javarush.task.task15.task1522;

/**
 * Created by korobovav on 25.05.2018.
 */
public class Earth implements Planet{

    private static Earth instance ;

    public static Earth getInstance() {
        if (instance == null ) {
            instance = new Earth();
        }
        return instance;
    }

    private Earth() {
    }
}
