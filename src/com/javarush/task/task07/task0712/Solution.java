package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by korobovav on 20.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList <String> arrayList = new ArrayList<>();
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        for (int i=0;i<10;i++) {
            arrayList.add(reader.readLine());
        }
        int minLen = arrayList.get(0).length();
        int maxLen = arrayList.get(0).length();
        int minIndex = 0;
        int maxIndex=0;
        for (int i=0;i<arrayList.size();i++) {
            if (arrayList.get(i).length()<minLen) {
                minLen=arrayList.get(i).length();
                minIndex=i;
            }
            if (arrayList.get(i).length()>maxLen) {
                maxLen=arrayList.get(i).length();
                maxIndex=i;
            }
        }
        if (minIndex<maxIndex) System.out.println(arrayList.get(minIndex));
        else System.out.println(arrayList.get(maxIndex));
    }
}
