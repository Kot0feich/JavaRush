package com.javarush.task.task18.task1810;

/*
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));
        boolean stop = false;
        do {
            String fileName = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(fileName);
            if (fileInputStream.available()<1000) {
                fileInputStream.close();
                stop=true;
                throw new DownloadException();
            }
        } while (!stop);
    }

    public static class DownloadException extends Exception {

    }
}
