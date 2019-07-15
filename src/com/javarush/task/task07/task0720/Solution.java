package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by korobovav on 23.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        ArrayList <String> arrayList = new ArrayList<>();
        for (int i=0;i<N;i++) {
            arrayList.add(reader.readLine());
        }
        for (int i=0;i<M;i++) {
            arrayList.add(arrayList.get(0));
            arrayList.remove(0);
        }
        for (int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
    }
}
