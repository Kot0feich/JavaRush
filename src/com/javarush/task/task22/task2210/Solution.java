package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
/*        String[] strArray = getTokens("level22.lesson13.task01", ".");
        for (int i = 0; i< strArray.length;i++) System.out.println(strArray[i]);*/
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        ArrayList<String> arrayList = new ArrayList<>();
        while(st.hasMoreTokens()) {
            arrayList.add(st.nextToken());
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }
}
