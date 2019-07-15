package com.javarush.task.task08.task0801;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by korobovav on 28.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("арбуз");
        hashSet.add("банан");
        hashSet.add("вишня");
        hashSet.add("груша");
        hashSet.add("дыня");
        hashSet.add("ежевика");
        hashSet.add("жень-шень");
        hashSet.add("земляника");
        hashSet.add("ирис");
        hashSet.add("картофель");
        for (String text : hashSet) {
            System.out.println(text);
        }
    }
}
