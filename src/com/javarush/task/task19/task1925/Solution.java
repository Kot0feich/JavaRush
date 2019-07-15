package com.javarush.task.task19.task1925;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
        String str = "";
        boolean wasFirst=false;
        //Pattern pattern = Pattern.compile("\\b([\\wа-яА-Я]){7,}\\b");
        Pattern pattern = Pattern.compile("[^\\s]{7,}");
        while ((str=bufferedReader.readLine())!=null) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                if (wasFirst) bufferedWriter.write(",");
                //System.out.println(matcher.group());
                bufferedWriter.write(matcher.group());
                wasFirst=true;
            }
        }
        bufferedReader.close();
        bufferedWriter.close();

    }
}
