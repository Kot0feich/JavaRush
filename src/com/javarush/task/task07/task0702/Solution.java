package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by korobovav on 19.06.2017.
 */
public class Solution {
    public static void
    main(String[] args) throws Exception {
        //напишите тут ваш код
        String [] strArray = new String[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<strArray.length;i++) {
        }

        for (int i=0;i<8;i++) {
            strArray[i]=reader.readLine();
        }
        for (int i=strArray.length-1;i>=0;i--){
            System.out.println(strArray[i]);
        }
    }
}
