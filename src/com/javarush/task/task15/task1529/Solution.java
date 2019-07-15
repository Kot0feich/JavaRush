package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static Flyable result;

    public static void reset() {
        //add your code here - добавьте код тут
        String inStr="";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
             inStr = reader.readLine();

        if (inStr.equals("helicopter")) result = new Helicopter();
        if (inStr.equals("plane")) {
            inStr = reader.readLine();
            result = new Plane(Integer.parseInt(inStr));

        }
            reader.close();
        }
        catch (Exception e) {

        }


    }
}
