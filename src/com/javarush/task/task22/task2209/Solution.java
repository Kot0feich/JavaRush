package com.javarush.task.task22.task2209;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;


/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String inStr=null;
        inStr=fileReader.readLine();
        String [] strings;
        StringBuilder result= new StringBuilder();
        if (!inStr.equals("")) {
            strings = inStr.split(" ");
            result= getLine(strings);
        }

        //...

        System.out.print(result);
    }

    public static StringBuilder getLine(String... words) {

        StringBuilder stringBuilder=new StringBuilder();
        StringBuilder maxStringBuilder = new StringBuilder();
        int maxWordCount=0;
        if (words.length==0) return stringBuilder;
        for (int k=0; k<words.length;k ++) {
            //передадим массив в список
            ArrayList<String> list = new ArrayList<>(Arrays.asList(words));
            //отсортируем список
            Collections.sort(list, new Comparator<String>() {
                public int compare(String o1, String o2) {
                    return o1.toString().compareTo(o2.toString());
                }
            });
            for (int i=0;i<k;i++) {
                list.add(list.get(0));
                list.remove(0);
            }
            stringBuilder = new StringBuilder(list.get(0) + " ");
            char lastChar = Character.toUpperCase(list.get(0).charAt(list.get(0).length() - 1));
            list.remove(0);

            Boolean stop = false;
            int i = 0, wordCount=1;
            while (!stop) {
                char firstChar = Character.toUpperCase(list.get(i).charAt(0));
                if (Character.toUpperCase(firstChar) == Character.toUpperCase(lastChar)) {
                    stringBuilder.append(list.get(i) + " ");
                    wordCount++;
                    lastChar = Character.toUpperCase(list.get(i).charAt(list.get(i).length() - 1));
                    list.remove(i);
                    i = 0;
                } else i++;
                if (list.size() == 0 || i == list.size()) stop = true;
            }
            //for (int j = 1; j < list.size(); j++) stringBuilder.append(list.get(j) + " ");
           // System.out.print(stringBuilder);
            //System.out.println(wordCount);
            if (wordCount>maxWordCount) {
                maxWordCount=wordCount;
                maxStringBuilder=stringBuilder;
            }

        }
        return maxStringBuilder;

    }
}
