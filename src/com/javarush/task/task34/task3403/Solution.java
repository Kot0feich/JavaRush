package com.javarush.task.task34.task3403;

/*
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recurse(int n) {
            int div = 2;
            while (div<=n) {
                if (n%div==0) {
                        System.out.println(div);
                        recurse(n / div);
                        return;
                }
                div ++;
            }

        }


    public static void main(String[] args) {
        new Solution().recurse(56);
    }
}
