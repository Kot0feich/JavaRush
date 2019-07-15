package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/*
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap <Integer, Integer> hashMap = new HashMap <> ();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available()>0) {
            Integer data;
            data = fileInputStream.read();
            if (hashMap.containsKey(data)) {
                Integer frequency = hashMap.get(data);
                hashMap.put(data,frequency== null ? 1 : frequency+1);
            }
            else {
                hashMap.put(data,1);
            }
        }
        fileInputStream.close();
        int maxValueMap = (Collections.max(hashMap.values()));
        Set<Map.Entry <Integer,Integer>> set = hashMap.entrySet();
        for (Map.Entry<Integer,Integer> entry : set) {
            if (entry.getValue()==maxValueMap) System.out.print(entry.getKey() + " ");
        }
    }
}
