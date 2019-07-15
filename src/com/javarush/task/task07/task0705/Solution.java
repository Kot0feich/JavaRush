package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by korobovav on 20.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        int [] intArray20 = new int [20];
        int [] intArray10_1 = new int [10];
        int [] intArray10_2 = new int [10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<20;i++) {
            intArray20[i]=Integer.parseInt(reader.readLine());
        }
        for (int i=0;i<20;i++) {
            if (i<10) intArray10_1[i]=intArray20[i];
            else intArray10_2[i-10]=intArray20[i];
        }
        for (int i=0;i<intArray10_2.length;i++) {
            System.out.println(intArray10_2[i]);
        }

    }
}
