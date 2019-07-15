package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.SyncFailedException;

/**
 * Created by korobovav on 20.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        int [] intArray = new int[15];
        int odd=0, even=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<intArray.length;i++) {
            intArray[i]=Integer.parseInt(reader.readLine());
            if (i%2==0) even+=intArray[i];
            else odd+=intArray[i];
        }
        if (even>odd) System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
