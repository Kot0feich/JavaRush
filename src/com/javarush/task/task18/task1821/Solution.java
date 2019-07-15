package com.javarush.task.task18.task1821;

/*
Встречаемость символов
*/

import java.io.FileInputStream;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception{
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        while (fileInputStream.available()>0) {
            int data=fileInputStream.read();
            if (treeMap.containsKey(data)) {
                int count = treeMap.get(data);
                treeMap.put(data,count+1);
            }
            else treeMap.put(data,1);
        }
        fileInputStream.close();
        for (Map.Entry <Integer,Integer> entry : treeMap.entrySet()) {
            System.out.println( ((char) entry.getKey().intValue()) + " " + entry.getValue());
        }
    }
}
