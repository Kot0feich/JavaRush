package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inStr="";
        do {
            inStr=reader.readLine();
            if (!inStr.equals("exit")) {
                try {
                    if (inStr.contains(".")) {
                        Double d1 = Double.parseDouble(inStr);
                        print(d1);
                    }
                    else {
                        int i1 = Integer.parseInt(inStr);
                        if (i1 <= 0 | i1 >= 128) {
                            print(i1);
                        }
                        if (i1 > 0 & i1 < 128){
                            print((short) i1);
                        }
                    }

                } catch (NumberFormatException e) {
                    print(inStr);
                }
            }

        } while (!inStr.equals("exit"));
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
