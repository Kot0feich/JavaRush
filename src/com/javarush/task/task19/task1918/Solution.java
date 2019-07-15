package com.javarush.task.task19.task1918;

/*
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;


public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReafer = new BufferedReader(new FileReader(fileName));
        String str="";
        StringBuilder sb = new StringBuilder();
        while ((str=fileReafer.readLine())!=null) {
            sb.append(str);
        }
        fileReafer.close();
        Document doc = null;
        doc = Jsoup.parse(sb.toString(),"",Parser.xmlParser());
        Element element;
        String tag=args[0];
        for (int i=0;i<doc.select(tag).size();i++) {
            element = doc.select(tag).get(i);
            String strOut = element.toString().replaceAll("[\\n\\r]","");
            //System.out.println(strOut.replaceAll("> ",">"));
            System.out.println(strOut);
        }

    }
}
