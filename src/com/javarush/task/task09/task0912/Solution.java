package com.javarush.task.task09.task0912;

/**
 * Created by korobovav on 20.07.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            //напишите тут ваш код

            int num = Integer.parseInt("XYZ");
            System.out.println(num);

            //напишите тут ваш код
        } catch (NumberFormatException e) {
            System.out.println(e.getClass().getTypeName());
        }
    }
}
