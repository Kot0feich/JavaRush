package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by korobovav on 10.07.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // find minimum here — найти минимум тут
        int min=array.get(0);
        for (Integer currValue : array) {
            if (currValue < min) min=currValue;
        }
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        //create and initialize a list here - создать и заполнить список тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List <Integer> list = new ArrayList<>();
        int N = Integer.parseInt(reader.readLine());
        for (int i=0;i<N;i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        return list;
    }
}
