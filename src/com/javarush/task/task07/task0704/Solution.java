package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by korobovav on 20.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        int [] intArray = new int[10];
        int [] intArrayTmp = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<10;i++) {
            intArray[i]=Integer.parseInt(reader.readLine());
        }
        for (int i=0;i<10;i++) {
            intArrayTmp[i]=intArray[9-i];
        }
        for (int i=0;i<10;i++) {
            intArray[i]=intArrayTmp[i];
            System.out.println(intArray[i]);
        }
    }
}
