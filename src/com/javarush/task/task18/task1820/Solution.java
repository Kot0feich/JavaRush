package com.javarush.task.task18.task1820;

/*
Округление чисел
*/

import java.io.*;
import java.nio.ByteBuffer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine(), fileName2 = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName1);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));
        while (fileInputStream.available()>0) {
            String strNum="";
            int data;
            do {
                data = fileInputStream.read();
                if (data>=0x30&&data<=0x39||data==0x2D||data==0x2E) strNum += (char) data;
            }
            while (!(data == 0x20 || data<0 || data == 0xD || data == 0xA));
            if (strNum!="") {
                int intNum = (int) Math.round(Double.parseDouble(strNum));
                bufferedWriter.write(intNum+" ");
            }
        }
        fileInputStream.close();
        bufferedWriter.close();

    }
}
