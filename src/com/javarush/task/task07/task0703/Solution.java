package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by korobovav on 20.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strArray = new String[10];
        int[] intArray = new int[10];
        for ( int i=0;i<10; i++) {
            strArray[i] = reader.readLine();
            intArray[i] = strArray[i].length();
        }
        for (int i=0;i<10;i++) {
            System.out.println(intArray[i]);
        }
    }
}
