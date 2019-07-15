package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.KeyStore;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        String str="";
        Pattern pattern = Pattern.compile(" ");
        Map <String, Double> treeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        while ((str = fileReader.readLine())!=null ) {
            String [] splitStr = pattern.split(str);
            String lastName = splitStr[0];
            double value = Double.parseDouble(splitStr[1]);
            if (treeMap.containsKey(lastName)) value=treeMap.get(lastName)+value;
            treeMap.put(lastName,value);
        }
        fileReader.close();
        for (Map.Entry<String,Double> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}
