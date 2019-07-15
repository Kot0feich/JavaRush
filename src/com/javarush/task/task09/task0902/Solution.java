package com.javarush.task.task09.task0902;

/**
 * Created by korobovav on 12.07.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        method1();
    }
    public static int method1() {
        method2();
        //напишите тут ваш код
        StackTraceElement [] stackTraceElement = Thread.currentThread().getStackTrace();
        return stackTraceElement[2].getLineNumber();
    }

    public static int method2() {
        method3();
        //напишите тут ваш код
        StackTraceElement [] stackTraceElement = Thread.currentThread().getStackTrace();
        return stackTraceElement[2].getLineNumber();
    }

    public static int method3() {
        method4();
        //напишите тут ваш код
        StackTraceElement [] stackTraceElement = Thread.currentThread().getStackTrace();
        return stackTraceElement[2].getLineNumber();
    }

    public static int method4() {
        method5();
        //напишите тут ваш код
        StackTraceElement [] stackTraceElement = Thread.currentThread().getStackTrace();
        return stackTraceElement[2].getLineNumber();
    }

    public static int method5() {
        //напишите тут ваш код
        StackTraceElement [] stackTraceElement = Thread.currentThread().getStackTrace();
        return stackTraceElement[2].getLineNumber();
    }
}
