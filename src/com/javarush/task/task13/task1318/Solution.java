package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/*
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String fileName;
        fileName = reader.readLine();
        InputStream inStream = new FileInputStream(fileName);
        while (inStream.available()>0)
        {
            int data = inStream.read();
            //System.out.print((char) data);
            writer.write(data);
        }
        inStream.close();
        reader.close();
        writer.close();
    }
}