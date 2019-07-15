package com.javarush.task.task05.task0532;

import java.io.*;

/*
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        //напишите тут ваш код
        int N=Integer.parseInt(reader.readLine());
        int maximum = Integer.parseInt(reader.readLine());
        for (int i=0;i<N-1;i++) {
            int a = Integer.parseInt(reader.readLine());
            if (maximum<a) maximum=a;
        }

        System.out.println(maximum);
    }
}
