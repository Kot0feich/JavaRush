package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int [] arr = new int[5];
        for (int i = 0; i<5; i++) {
            arr [i] = Integer.parseInt(reader.readLine());
        }
        int i = 0;
        while (i<4) {
            if (arr[i]>arr[i+1]) {
                int tmp = arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=tmp;
                i=0;
            }
            else i++;
        }
        for (i = 0; i<5; i++) {
            System.out.println(arr[i]);;
        }
    }
}
