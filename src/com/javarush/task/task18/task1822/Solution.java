package com.javarush.task.task18.task1822;

/*
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "d:\\a.txt";//reader.readLine();
        BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
        String str;
        while ((str=readerFile.readLine())!= null) {
            int id = Integer.parseInt(str.substring(0,str.indexOf(0x20)));
            if (id==Integer.parseInt(args[0])) System.out.println(str);
        }
        reader.close();
        readerFile.close();

    }
}
