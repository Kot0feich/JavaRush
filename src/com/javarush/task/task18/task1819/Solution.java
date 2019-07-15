package com.javarush.task.task18.task1819;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName1);
        byte [] buffer = new byte[fileInputStream.available()];
        int count = fileInputStream.read(buffer);
        fileInputStream.close();
        fileInputStream = new FileInputStream(fileName2);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
        byte [] buffer2 = new byte[fileInputStream.available()];
        int count2 = fileInputStream.read(buffer2);
        fileOutputStream.write(buffer2);
        fileOutputStream.write(buffer);
        fileInputStream.close();
        fileOutputStream.close();
    }

}
