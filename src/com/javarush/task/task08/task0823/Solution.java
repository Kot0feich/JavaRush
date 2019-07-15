package com.javarush.task.task08.task0823;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by korobovav on 11.07.2017.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        String strToReplace="";
        char chrToReplace=Character.toUpperCase(s.charAt(0));
        for (int i=0;i<s.length();i++) {
            if (i!=0) {
                if (s.charAt(i-1)==' ') chrToReplace = Character.toUpperCase(s.charAt(i));
                else chrToReplace=s.charAt(i);
            }
            strToReplace+=Character.toString(chrToReplace);
        }
        System.out.println(strToReplace);
    }
}
