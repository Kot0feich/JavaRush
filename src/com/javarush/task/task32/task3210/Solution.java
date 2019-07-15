package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Используем RandomAccessFile
*/

public class Solution  {
    public static void main(String... args) throws Exception{
        String fileName = args[0];
        Integer number = Integer.parseInt(args[1]);
        String text = args[2];
        Integer length= text.length();
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName,"rw");
        randomAccessFile.seek(number);
        byte [] bytes =new byte[length];
        randomAccessFile.read(bytes ,0, length);
        String str = new String(bytes);
        randomAccessFile.seek(randomAccessFile.length());
        if (str.equals(text)) randomAccessFile.write("true".getBytes());
        else randomAccessFile.write("false".getBytes());


    }
}
