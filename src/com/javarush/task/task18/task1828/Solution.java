package com.javarush.task.task18.task1828;

/*
Прайсы 2
*/

import java.io.*;
import java.nio.charset.StandardCharsets;


public class Solution {
    private static String formatString (int id, String productName, String price, String quantity) {
        String outStr =
                String.format("%-8s", Integer.toString(id)) +
                String.format("%-30s", productName) +
                String.format("%-8s", price) +
                String.format("%-4s", quantity);
        return outStr;
    }
   /* private static void addString (String fileName, String[] args) throws Exception{
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String inStr = "";
        int maxId = 0;
        while ((inStr = fileReader.readLine()) != null) {
            int id = Integer.parseInt(inStr.substring(0, 8).replaceAll(" ", ""));
            if (id > maxId) maxId = id;
        }
        fileReader.close();
        String outStr = formatString(maxId+1,args[1],args[2],args[3]);
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));
        fileWriter.write("\n" +outStr);
        fileWriter.close();
    }
    private static void updString (String fileName, String [] args) throws Exception {
        String inStr = "", outStr="";
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName+".tmp",true));
        while (((inStr = fileReader.readLine()) != null)) {
            int id = Integer.parseInt(inStr.substring(0, 8).replaceAll(" ", ""));
            if (id==Integer.parseInt(args[1])) {
                outStr=formatString(id,args[2],args[3], args[4]);
                fileWriter.write(outStr+"\n");
            }
            else fileWriter.write(inStr+"\n");
        }
        fileWriter.close();
        fileReader.close();
        java.io.File tmpFile = new java.io.File (fileName+".tmp");
        java.io.File file = new java.io.File(fileName);
        file.delete();
        tmpFile.renameTo(file);
    }
    public static void delString (String fileName, String [] args) throws Exception {
        String inStr = "";
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName+".tmp",true));
        while (((inStr = fileReader.readLine()) != null)) {
            int id = Integer.parseInt(inStr.substring(0, 8).replaceAll(" ", ""));
            if (id != Integer.parseInt(args[1])) fileWriter.write(inStr + "\n");
        }
        fileWriter.close();
        fileReader.close();
        java.io.File tmpFile = new java.io.File (fileName+".tmp");
        java.io.File file = new java.io.File(fileName);
        file.delete();
        tmpFile.renameTo(file);
    }*/
    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        switch (args[0]) {
            case "-c": {
                //addString(fileName,args);
                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                String inStr = "";
                int maxId = 0;
                while ((inStr = fileReader.readLine()) != null) {
                    int id = Integer.parseInt(inStr.substring(0, 8).replaceAll(" ", ""));
                    if (id > maxId) maxId = id;
                }
                fileReader.close();
                String outStr = formatString(maxId+1,args[1],args[2],args[3]);
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));
                fileWriter.write("\n" +outStr);
                fileWriter.close();
                break;
            }
            case "-u": {
                //updString(fileName,args);
                String inStr = "", outStr="";
                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName+".tmp",true));
                while (((inStr = fileReader.readLine()) != null)) {
                    int id = Integer.parseInt(inStr.substring(0, 8).replaceAll(" ", ""));
                    if (id==Integer.parseInt(args[1])) {
                        outStr=formatString(id,args[2],args[3], args[4]);
                        fileWriter.write(outStr+"\n");
                    }
                    else fileWriter.write(inStr+"\n");
                }
                fileWriter.close();
                fileReader.close();
                java.io.File tmpFile = new java.io.File (fileName+".tmp");
                java.io.File file = new java.io.File(fileName);
                file.delete();
                tmpFile.renameTo(file);
                break;
            }
            case "-d" : {
                //delString(fileName,args);
                String inStr = "";
                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName+".tmp",true));
                while (((inStr = fileReader.readLine()) != null)) {
                    int id = Integer.parseInt(inStr.substring(0, 8).replaceAll(" ", ""));
                    if (id != Integer.parseInt(args[1])) fileWriter.write(inStr + "\n");
                }
                fileWriter.close();
                fileReader.close();
                java.io.File tmpFile = new java.io.File (fileName+".tmp");
                java.io.File file = new java.io.File(fileName);
                file.delete();
                tmpFile.renameTo(file);
                break;
            }
        }
    }
}
