package com.javarush.task.task15.task1522;

/**
 * Created by korobovav on 25.05.2018.
 */
public class Sun implements Planet{
    private static Sun instance ;

    public static Sun getInstance() {
        if (instance == null ) {
            instance = new Sun();
        }
        return instance;
    }

    private Sun() {
    }
}
