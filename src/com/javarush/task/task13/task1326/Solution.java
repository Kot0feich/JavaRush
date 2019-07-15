package com.javarush.task.task13.task1326;

/*
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "k";
        InputStream inputStream = new FileInputStream(fileName);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        String str = "";
        int intStr=0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int result = inputStream.read();
        int result2;
        while (result !=-1 ) {
            //System.out.println(Integer.toHexString(result));
            if (result!=0x0A && result>0) {
                str=str+(char) result;
                intStr = Integer.parseInt(str);

            }
            else {
                if (intStr%2==0) arrayList.add(intStr);
                str="";
            }
            result = inputStream.read();
        }
        Collections.sort(arrayList);
        for (int i=0; i<arrayList.size();i++) System.out.println(arrayList.get(i));
        inputStream.close();
    }
}
