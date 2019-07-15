package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;

/*
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int max=fileInputStream.read();
        int data;
        while (fileInputStream.available()>0) {
            data=fileInputStream.read();
            max = (max>data ? max : data);
        }
        System.out.println(max);
        fileInputStream.close();
    }
}
