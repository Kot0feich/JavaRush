package com.javarush.task.task22.task2202;

import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {

        int firstSpace = 0;
        int index = 0;
        if(string == null) throw new TooShortStringException();
            firstSpace = string.indexOf(" ");
            if (firstSpace==-1) throw new TooShortStringException();
            index = firstSpace;
            for (int i = 1; i < 4; i++) {
                index = string.indexOf(" ", index + 1);
                if (index==-1) throw new TooShortStringException();
            }
        Pattern pattern = Pattern.compile("\\s");
        String[] splitStr = pattern.split(string.substring(index+1));
        index+=splitStr[0].length();
        return string.substring(firstSpace+1,index+1);

    }

    public static class TooShortStringException extends RuntimeException{
    }
}
