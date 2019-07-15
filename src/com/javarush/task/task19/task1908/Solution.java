package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName1);
        BufferedReader fileBufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(fileName2);
        BufferedWriter fileBufferedWriter = new BufferedWriter(fileWriter);
        Pattern pattern = Pattern.compile("\\b(\\d*)\\b");
        String str="";
        while ((str = fileBufferedReader.readLine()) != null) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                if (!matcher.group().equals("")) fileBufferedWriter.write(matcher.group()+" ");
            }
        }
        fileBufferedReader.close();
        fileBufferedWriter.close();
    }
}
