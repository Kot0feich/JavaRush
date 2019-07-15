package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by korobovav on 20.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList <String> arrayList = new ArrayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<5;i++) {
            arrayList.add(reader.readLine());
        }
        int maxStrLen=arrayList.get(0).length();
        for (int i=1;i<arrayList.size();i++) {
            if (arrayList.get(i).length()>maxStrLen)  {
                maxStrLen=arrayList.get(i).length();
            }
        }
        for (int i=0;i<arrayList.size();i++) {
            if (arrayList.get(i).length()==maxStrLen) System.out.println(arrayList.get(i));
        }

    }
}
