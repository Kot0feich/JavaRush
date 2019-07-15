package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        for (int j=0;j<33;j++) {
            int count = 0;
            char findingChar = alphabet.get(j);
            //System.out.print(findingChar+" ");
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                for (int k = 0;k<s.length();k++) {
                    if (s.charAt(k)==findingChar) count++;
                }
            }
            System.out.println(findingChar+" "+count);
        }


        // напишите тут ваш код
    }

}
