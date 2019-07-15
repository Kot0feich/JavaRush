package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by korobovav on 22.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        ArrayList <String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0;i<10;i++) {
            list.add(reader.readLine());
        }
        ArrayList<String> result = doubleValues(list);
        for (String x: result)
            System.out.println(x);

    }
    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        //напишите тут ваш код
        Boolean doWork = true;
        int finalSize=list.size()*2;
        int i=0;
        while (doWork) {
            list.add(i+1,list.get(i));
            i=i+2;
            if (i>=finalSize) doWork=false;
        }
        return list;
    }
}
