package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName="";
        do {
            fileName = reader.readLine();
            if (!fileName.equals("exit")) {
                ReadThread readThread = new ReadThread(fileName);
                readThread.start();
            }
        }
        while (!fileName.equals("exit"));
    }
    public static class ReadThread extends Thread {
        private FileInputStream fileInputStream;
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
                this.fileName=fileName;

        }
        // implement file reading here - реализуйте чтение из файла тут

        public void run () {

            try {
                HashMap <Integer, Integer> hashMap = new HashMap<>();
                fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available()>0) {
                    int data = fileInputStream.read();
                    if (hashMap.containsKey(data)) {
                        int frequency = hashMap.get(data);
                        hashMap.put(data,frequency+1);
                    }
                    else
                        hashMap.put (data,1);
                }
                int maxHashValue = Collections.max(hashMap.values());
                for (HashMap.Entry<Integer,Integer> entry: hashMap.entrySet()) {
                    if (entry.getValue()== maxHashValue) resultMap.put(this.fileName, entry.getKey());
                }
                //System.out.println(resultMap);
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
