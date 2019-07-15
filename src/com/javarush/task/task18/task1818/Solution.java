package com.javarush.task.task18.task1818;

/*
Два в одном
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
        String fileName3 = reader.readLine();
        reader.close();

        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName1,true);
        FileInputStream fileInputStream2 = new FileInputStream(fileName2);
        FileInputStream fileInputStream3 = new FileInputStream(fileName3);

        byte [] buffer2 = new byte[fileInputStream2.available()];
        byte [] buffer3 = new byte[fileInputStream3.available()];
        int count2 = fileInputStream2.read(buffer2);
        int count3 = fileInputStream3.read(buffer3);

        fileInputStream2.close();
        fileInputStream3.close();

        fileOutputStream1.write(buffer2);
        fileOutputStream1.write(buffer3);
        fileOutputStream1.close();
    }
}
