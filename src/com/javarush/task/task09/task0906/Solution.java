package com.javarush.task.task09.task0906;

/**
 * Created by korobovav on 19.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        StackTraceElement [] stackTraceElement = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElement[2].getClassName() + ":" + stackTraceElement[2].getMethodName()+":"+s);

    }
}
