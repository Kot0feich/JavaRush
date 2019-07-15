package com.javarush.task.task13.task1326_1;

/*
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.LinkedList;

/*
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        String line;
        List<Integer> list = new LinkedList<>();
        if (fileReader.ready())
            while ((line = fileReader.readLine()) != null) {
                list.add(Integer.valueOf(line));
            }

       // list.stream().filter(v -> v % 2 == 0).sorted().forEach(System.out::println);

        reader.close();
        fileReader.close();
    }
}