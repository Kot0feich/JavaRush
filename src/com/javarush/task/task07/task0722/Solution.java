package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by korobovav on 28.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList <String> arrayList = new ArrayList<>();
        boolean doWork = true;
        for (int i=0;doWork;i++) {
            String addString = reader.readLine();
            if (addString.equals("end")) doWork=false;
            else arrayList.add(addString);
        }
        for (int i=0;i<arrayList.size();i++) {
            System.out.println(arrayList.get(i));
        }

    }
}
