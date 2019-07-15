package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        FileInputStream inputStreamReader = new FileInputStream(fileName);
        int data;
        int min = inputStreamReader.read();
        while (inputStreamReader.available()>0) {
            data = inputStreamReader.read();
            min = (min<data ? min : data);
        }
        System.out.println(min);
        inputStreamReader.close();
    }
}
