package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.StringJoiner;

/*
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] arrayList  = new ArrayList[2];
        arrayList[0]=new ArrayList<String>();
        arrayList[0].add("1");
        arrayList[1]=new ArrayList<String>();
        arrayList[1].add("2");
        return arrayList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}