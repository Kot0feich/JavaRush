package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by korobovav on 22.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        for (int i=0;i<10;i++) {
            arrayList.add(reader.readLine());
        }
        Boolean doWork=true;
        int i=0;
            while (doWork) {
                if (arrayList.get(i).length() >= arrayList.get(i + 1).length())  {
                    System.out.println(i + 1);
                    doWork = false;
                }
                if (i >= arrayList.size() - 2) doWork = false;
                i++;
            }

    }
}
