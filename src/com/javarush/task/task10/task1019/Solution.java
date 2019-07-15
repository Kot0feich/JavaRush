package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        String strVal="";
        try {
            do {
                strVal = reader.readLine();
                if (!strVal.isEmpty()) {
                    int intVal = Integer.parseInt(strVal);
                    String strKey = reader.readLine();
                    map.put(strKey, intVal);
                }
            }
            while (!strVal.isEmpty());
        }
        catch (Exception e) {

        }
        for (Map.Entry<String,Integer> pair : map.entrySet()) {
            System.out.println(pair.getValue()+" "+pair.getKey());
        }
    }
}
