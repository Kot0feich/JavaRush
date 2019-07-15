package com.javarush.task.task13.task1326_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by korobovav on 30.03.2018.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        //BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        FileInputStream fileInputStream = new FileInputStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader fileReader = new BufferedReader(inputStreamReader);
        ArrayList <Integer> arrayList = new ArrayList<Integer>();
        String line="";
        line=fileReader.readLine();
        while (line!=null) {
            System.out.println(line);
            line=fileReader.readLine();
        }
    }

}
