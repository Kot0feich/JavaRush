package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String str;
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        while ((str=fileReader.readLine())!=null) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                String sourceStr = matcher.group();
                    if (map.containsKey(Integer.parseInt(sourceStr))) {
                        String targetStr = map.get(Integer.parseInt(sourceStr));
                        str = str.replaceAll("\\b"+sourceStr+"\\b",targetStr);
                    }
            }
            System.out.println(str);
        }
        fileReader.close();
    }
}
