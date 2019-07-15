package com.javarush.task.task07.task0719;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by korobovav on 23.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        ArrayList <Integer> arrayList = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<10;i++){
            arrayList.add(Integer.parseInt(reader.readLine()));
        }
        for (int i=arrayList.size()-1;i>=0;i--) {
            System.out.println(arrayList.get(i));
        }
    }
}
