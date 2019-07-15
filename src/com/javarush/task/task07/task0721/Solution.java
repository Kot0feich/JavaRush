package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by korobovav on 28.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
        int [] intArray = new int [20];
        for (int i=0;i<20;i++) {
            intArray[i]=Integer.parseInt(reader.readLine());
        }
        maximum=intArray[0];
        minimum=intArray[0];
        for (int i=1;i<intArray.length;i++) {
            if (intArray[i]<minimum) minimum=intArray[i];
            if (intArray[i]>maximum) maximum=intArray[i];
        }

        System.out.println(maximum);
        System.out.println(minimum);
    }
}
