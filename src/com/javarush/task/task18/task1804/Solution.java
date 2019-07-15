package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        HashMap <Integer, Integer> hashMap = new HashMap<>();
        while (fileInputStream.available()>0) {
            int data=fileInputStream.read();
            if (hashMap.containsKey(data)) {
                int count = hashMap.get(data);
                hashMap.put(data,count+1);
            }
            else hashMap.put(data,1);
        }
        int minHashMapValue = Collections.min(hashMap.values());
        Set<HashMap.Entry <Integer,Integer>> set = hashMap.entrySet();
        for (HashMap.Entry<Integer,Integer> entry : set) {
            if (entry.getValue()==minHashMapValue) System.out.print(entry.getKey()+" ");
        }
        fileInputStream.close();
    }
}
