package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/**
 * Created by korobovav on 20.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList <String> arrayList = new ArrayList();
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add("third");
        arrayList.add("fourth");
        arrayList.add("fifth");
        System.out.println(arrayList.size());
        for (int i=0;i<arrayList.size();i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
