package com.javarush.task.task07.task0723;

/**
 * Created by korobovav on 28.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 30; i >= 0; i--) {
            System.out.println(i);
            Thread.sleep(100);

            //напишите тут ваш код
        }

        System.out.println("Бум!");
    }
}
