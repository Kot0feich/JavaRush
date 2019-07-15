package com.javarush.task.task13.task1319;

import java.io.*;

/*
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter writer = new BufferedWriter((new OutputStreamWriter(System.out)));

        String fileName;
        String inString="";
        fileName=reader.readLine();
        BufferedWriter writer = new BufferedWriter((new FileWriter(fileName)));
        while (!inString.equals("exit")) {
            inString = reader.readLine();
            writer.write(inString+"\n");
        }
        writer.close();
        reader.close();
    }
}
