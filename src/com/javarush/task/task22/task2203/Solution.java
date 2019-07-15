package com.javarush.task.task22.task2203;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws Exception{
        if(string == null) throw new TooShortStringException();
        int firstIndex = string.indexOf('\t')+1;
        int lastIndex = string.indexOf('\t',firstIndex);

        if ((firstIndex==-1)||(lastIndex==-1)) throw new TooShortStringException();
        return string.substring(firstIndex,lastIndex);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
