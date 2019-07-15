package com.javarush.task.task18.task1808;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileName2);
        FileOutputStream fileOutputStream3 = new FileOutputStream(fileName3);
        int fileSize1 = fileInputStream1.available();
        int fileSize2, fileSize3;
        if ((fileSize1 % 2) == 0)  {
            fileSize2=fileSize1/2;
            fileSize3=fileSize2;
        }
        else {
            fileSize2=fileSize1/2+1;
            fileSize3=fileSize1/2;
        }
        byte[] buf2 = new byte [fileSize2];
        byte[] buf3 = new byte [fileSize3];

        while (fileInputStream1.available()>0) {
            int count = fileInputStream1.read(buf2);
            fileOutputStream2.write(buf2,0,count);
            count = fileInputStream1.read(buf2);
            fileOutputStream3.write (buf2,0,count);
        }
        fileInputStream1.close();
        fileOutputStream2.close();
        fileOutputStream3.close();



    }
}
