package com.javarush.task.task19.task1927;

/*
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream stream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream currStream = new PrintStream(byteArrayOutputStream);
        System.setOut(currStream);
        testString.printSomething();
        String result = byteArrayOutputStream.toString();
        System.setOut(stream);
        //System.out.println(System.lineSeparator() + result);
        String [] splitStr = result.split(System.lineSeparator());
        for (int i=0;i<splitStr.length;i++) {
            System.out.println(splitStr[i]);
            if ((i%2) != 0) System.out.println("JavaRush - курсы Java онлайн");
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
