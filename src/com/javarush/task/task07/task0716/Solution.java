package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by korobovav on 21.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("лира");
        list.add("роза"); //0
        list.add("роза");
        list.add("роза");
        list.add("лоза");
        list.add("лоза"); //1
        list.add("лира"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        //напишите тут ваш код
        boolean doWork=true;
        int i=0;
        while (doWork) {
            if (list.get(i).contains("р") && !list.get(i).contains("л")) {
                list.remove(i);
            }
            else i++;
            if (i>list.size()-1) doWork=false;
        }
        doWork=true;
        i=0;
        while (doWork) {
            if (!list.get(i).contains("р") && list.get(i).contains("л")) {
                    list.add(i+1,list.get(i));
                    i++;
                }
            i++;
            if (i>list.size()-1) doWork=false;
        }
        return list;
    }
}
