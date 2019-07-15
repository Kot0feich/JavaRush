package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = "d:\\a.txt";//reader.readLine();
        String nameFile2 = "d:\\b.txt";//reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(nameFile1));
        BufferedWriter fileWriter = new BufferedWriter((new FileWriter(nameFile2)));
        String string="";
        Pattern pattern = Pattern.compile("[\\W&&[\\S]]");
        while (!((string = fileReader.readLine())==null)) {
            Matcher matcher = pattern.matcher(string);
            fileWriter.write(matcher.replaceAll(""));
        }
        fileReader.close();
        fileWriter.close();
    }
}
