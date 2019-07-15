package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/*
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("");
        System.out.println(decode(null, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        String retStr;
        if (reader==null) return "";
        StringWriter stringWriter = new StringWriter();
        StringBuilder stringBuilder = new StringBuilder();
        int ch;
        while ((ch = reader.read())!=-1) {
            stringWriter.append((char) (ch+key));
        }
        retStr =  stringWriter.toString();
        return retStr==null?"":retStr;
    }
}
