package com.javarush.task.task18.task1809;

/*
Реверс файла
*/

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
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        byte [] buffer = new byte[fileInputStream.available()];
        while (fileInputStream.available()>0) {
            int count = fileInputStream.read(buffer);
        }
        for (int i=buffer.length-1;i>=0;i--) {
            fileOutputStream.write(buffer[i]);
        }
        fileInputStream.close();
        fileOutputStream.close();

    }
}
