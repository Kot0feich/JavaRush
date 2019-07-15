package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by korobovav on 20.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList <String> arrayList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<5;i++) {
            arrayList.add(reader.readLine());
        }
        for (int i=0;i<13;i++){
            String tmpValue=arrayList.get(arrayList.size()-1);
            arrayList.remove(arrayList.size()-1);
            arrayList.add(0,tmpValue);
        }
        for (int i=0;i<arrayList.size();i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
