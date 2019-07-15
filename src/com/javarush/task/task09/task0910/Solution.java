package com.javarush.task.task09.task0910;

import java.util.ArrayList;

/**
 * Created by korobovav on 20.07.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            //напишите тут ваш код

            ArrayList<String> list = new ArrayList<String>();
            String s = list.get(18);

            //напишите тут ваш код
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass().getTypeName());
        }
    }
}
