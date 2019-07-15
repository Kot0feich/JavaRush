package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new HashMap<String, String>();
        String inStr="";
        try {
            inStr = reader.readLine();
        }
        catch (IOException e) {
        }
        int startPos = inStr.indexOf("?")+1;
        int endPos = inStr.indexOf("&",startPos);
        while (startPos<inStr.length()||endPos>0) {
            String parm = inStr.substring(startPos, endPos);
            if (parm.contains("=")) {
                map.put(parm.substring(0,parm.indexOf("=")),parm.substring(parm.indexOf("=")+1, parm.length()));
                System.out.print(parm.substring(0,parm.indexOf("="))+" ");
            }
            else {
                map.put(parm, "");
                System.out.print(parm + " ");
            }

            startPos = endPos+1;
            endPos = inStr.indexOf("&",startPos);
            if (endPos<1&&startPos<inStr.length()) endPos=inStr.length()-1;
            //System.out.print(parm+" ");
        }
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
/*        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            System.out.print(entry.getKey());
            if (entries.hasNext()) System.out.print(" ");
        }*/
        System.out.println("");
        if (map.containsKey("obj")) {
            try {
                alert(Double.parseDouble(map.get("obj")));
            } catch (NumberFormatException e) {
                alert(map.get("obj"));
            }
        }



    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
