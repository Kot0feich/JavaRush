package com.javarush.task.task18.task1817;

/*
Пробелы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int spaceCount=0, allCount = 0;
        while (fileInputStream.available()>0) {
            int data = fileInputStream.read();
            allCount++;
            if (data==0x20) spaceCount++;
        }
        fileInputStream.close();
        double relation = ((double) spaceCount / (double) allCount)*100;
        System.out.format("%.2f%n", relation);
    }
}
