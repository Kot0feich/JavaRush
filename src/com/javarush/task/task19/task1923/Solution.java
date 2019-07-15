package com.javarush.task.task19.task1923;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        String str = "";
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        Pattern pattern=Pattern.compile("\\b\\S*\\d+\\S*\\b");
        boolean itsFirst=true;
        while ((str=fileReader.readLine())!=null) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                if (itsFirst) {fileWriter.write(matcher.group()); itsFirst=!itsFirst;}
                else fileWriter.write(" " + matcher.group());
            }
        }
        fileReader.close();
        fileWriter.close();

    }
}
