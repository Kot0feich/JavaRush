package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/*
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        List<Integer> list = new ArrayList<>();
        while (fileInputStream.available()>0) {
            int data = fileInputStream.read();
            if (!list.contains(data)) list.add(data);
        }
        fileInputStream.close();
        Collections.sort(list,new Comparator<Integer>(){
                public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        //System.out.println(list);
        for (int i : list) System.out.print(i + " ");
    }
}
