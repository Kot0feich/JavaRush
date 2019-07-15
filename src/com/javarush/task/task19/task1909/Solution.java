package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = reader.readLine();
        String nameFile2 = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(nameFile1));
        BufferedWriter fileWriter = new BufferedWriter((new FileWriter(nameFile2)));
        String string="";
        Pattern pattern = Pattern.compile("\\.");
        while (!((string = fileReader.readLine())==null)) {
            Matcher matcher = pattern.matcher(string+"\n");
            fileWriter.write(matcher.replaceAll("!"));
        }
        fileReader.close();
        fileWriter.close();
    }
}
