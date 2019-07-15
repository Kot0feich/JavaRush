package com.javarush.task.task19.task1914;

/*
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.out.println(result);
        System.setOut(console);
        Pattern pattern = Pattern.compile("(\\d+) ([\\+\\-*=]) (\\d+) (=)");
        Matcher matcher = pattern.matcher(result);
        int a=0,b=0,c=0;
        String sign = "", eql="";
        while (matcher.find()) {
            sign = matcher.group(2);
            a=Integer.parseInt(matcher.group(1));
            b=Integer.parseInt(matcher.group(3));
            eql = matcher.group(4);
            switch (sign) {
                case "+" : c=a+b;
                break;
                case "-" : c=a-b;
                break;
                case "*" : c=a*b;
            }
        }
        System.out.print(result);;
        System.out.println(c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

