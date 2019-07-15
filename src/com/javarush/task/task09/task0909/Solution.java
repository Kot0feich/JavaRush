package com.javarush.task.task09.task0909;

/**
 * Created by korobovav on 20.07.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            //напишите тут ваш код

            int[] m = new int[2];
            m[8] = 5;

            //напишите тут ваш код
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getClass().getTypeName());
        }
    }
}
