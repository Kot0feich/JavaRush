package com.javarush.task.task18.task1816;

/*
Английские буквы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        byte [] buffer = new byte [fileInputStream.available()];
        while (fileInputStream.available()>0) {
            int count = fileInputStream.read(buffer);
        }
        fileInputStream.close();
        int symbCount=0;
        for (int i=0; i<=buffer.length-1;i++) {
            if (buffer[i]>=0x41&&buffer[i]<=0x5A || buffer[i]>=0x61&&buffer[i]<=0x7A) {
               symbCount++;
            }
        }
        System.out.println(symbCount);
    }
}
