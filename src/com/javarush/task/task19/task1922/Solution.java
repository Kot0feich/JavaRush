package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String str = "";
        while ((str=fileReader.readLine())!=null) {
            int count = 0;
            for (String list : words) {
                Pattern pattern = Pattern.compile("\\b" + list  + "\\b");
                //Pattern pattern = Pattern.compile("\\bвид\\b");
                Matcher matcher = pattern.matcher(str);
                while (matcher.find()) {
                    count++;
                    System.out.println(matcher.group());
                }
            }
            if (count==2) System.out.println(str);
        }
        fileReader.close();

    }
}
