package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;


    //add your code here - добавьте код тут
    static {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }
        catch (Exception e) {}
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface  {
        public void run ()
        {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                try {
                    String fileString="";
                    fileString = reader.readLine();
                    while (fileString!= null) {
                        fileContent = fileContent + " " + fileString ;
                        fileString = reader.readLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        public void setFileName (String fileName) {
            this.fileName = fileName;
        };
        public String getFileContent() {
            return fileContent;
        };

        private String fileName;
        private String fileContent = "";
    };

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
}
