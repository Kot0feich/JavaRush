package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SortedSet<String> treeSet = new TreeSet<>();
        boolean stopProcessing=false;
        String fileName = reader.readLine();
        String baseFileName = fileName.substring(0,fileName.lastIndexOf("."));
        while (!fileName.equals("end")) {
            treeSet.add(fileName);
            fileName = reader.readLine();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(baseFileName);
        Iterator<String> iterator = treeSet.iterator();

        while (iterator.hasNext()) {
            fileName = iterator.next();
            FileInputStream fileInputStream = new FileInputStream(fileName);
            byte [] buffer = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            fileOutputStream.write(buffer,0,count);
            fileInputStream.close();
        }
        fileOutputStream.close();


    }
}
