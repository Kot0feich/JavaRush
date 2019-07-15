package com.javarush.task.task18.task1824;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean stopProcessing=false;
        String nameFile="";
        while ( !stopProcessing) {
            try {
                nameFile = reader.readLine();
                FileInputStream fileInputStream = new FileInputStream(nameFile);
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(nameFile);
                stopProcessing=true;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
