package com.javarush.task.task07.task0715;

import java.util.ArrayList;


/**
 * Created by korobovav on 21.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList <String> arrayList = new ArrayList<>();
        arrayList.add("мама");
        arrayList.add("мыла");
        arrayList.add("раму");
        arrayList.add(1,"именно");
        arrayList.add(3,"именно");
        arrayList.add(5,"именно");
        for (int i=0;i<arrayList.size();i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
