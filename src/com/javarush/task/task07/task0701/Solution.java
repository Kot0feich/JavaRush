package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by korobovav on 19.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        // создай и заполни массив
        int [] intArray = new int [20];
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        for (int i=0;i<intArray.length;i++) {
            intArray[i]=Integer.parseInt(reader.readLine());
        }
        return intArray;
    }

    public static int max(int[] array) {
        // найди максимальное значение
        int maxArray = array[0];
        for (int i=1;i<array.length;i++) {
            if (array[i]>maxArray) maxArray = array[i];
        }
        return maxArray;
    }
}
