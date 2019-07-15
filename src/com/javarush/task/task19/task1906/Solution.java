package com.javarush.task.task19.task1906;

/*
Четные символы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);
        Boolean isForWrite = false;
        while (fileReader.ready()) {
            int data = fileReader.read();
            if (isForWrite) fileWriter.write(data);
            isForWrite=!isForWrite;
        }
        fileReader.close();
        fileWriter.close();

    }
}
