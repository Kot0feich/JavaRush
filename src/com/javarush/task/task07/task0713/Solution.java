package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by korobovav on 20.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList <Integer> List = new ArrayList<Integer>();
        ArrayList <Integer> List1 = new ArrayList<Integer>();
        ArrayList <Integer> List2 = new ArrayList<Integer>();
        ArrayList <Integer> List3 = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<20;i++) {
            List.add(Integer.parseInt(reader.readLine()));
        }
        for (int i=0;i<List.size();i++) {
            if (List.get(i) % 3 == 0) List1.add(List.get(i));
            if (List.get(i) % 2==0) List2.add(List.get(i));
            if (List.get(i) % 3 !=0 && List.get(i) % 2 != 0) List3.add(List.get(i));

        }
        printList(List1);
        printList(List2);
        printList(List3);
    }
    public static void printList (List<Integer> List) {
        for (int i=0;i<List.size();i++) {
            System.out.println(List.get(i));
        }
    }
}
