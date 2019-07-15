package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        TreeMap <String, Double> treeMap = new TreeMap <String,Double> (String.CASE_INSENSITIVE_ORDER);
        Pattern pattern = Pattern.compile(" ");
        String str = "";

        while ((str=fileReader.readLine())!=null) {
            String [] splitStr = pattern.split(str);
            String lastName = splitStr[0];
            Double value = Double.parseDouble(splitStr[1]);
            if (treeMap.containsKey(lastName)) {
                Double currValue = treeMap.get(lastName);
                treeMap.replace(lastName,currValue+value);

            }
            else
                treeMap.put(lastName,value);
        }
        Double maxValue= Collections.max(treeMap.values());
        for (Map.Entry<String,Double> entry : treeMap.entrySet()) {
            if (entry.getValue().equals(maxValue)) System.out.println(entry.getKey());
        }
        fileReader.close();
    }
}
