package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        int count = 0;
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            Pattern p = Pattern.compile("\\bworld\\b");
            Matcher m = p.matcher(str);
            while (m.find())
                count++;
        }
        scanner.close();
        fileReader.close();
        System.out.println(count);
    }

}
