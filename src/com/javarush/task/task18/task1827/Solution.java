package com.javarush.task.task18.task1827;

/*
Прайсы
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length==0) return;
        if (args[0].equals("-c")) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String inStr = "";
            int maxId = 0;
            while ((inStr = fileReader.readLine()) != null) {
                int id = Integer.parseInt(inStr.substring(0, 8).replaceAll(" ", ""));
                if (id > maxId) maxId = id;
            }
            fileReader.close();
            String outStr = "\n" +
                    String.format("%-8s", Integer.toString(maxId + 1)) +
                    String.format("%-30s", args[1]) +
                    String.format("%-8s", args[2]) +
                    String.format("%-4s", args[3]);
//        System.out.println("\'" + outStr + "\'");

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));
            fileWriter.write(outStr);
            fileWriter.close();
        }
    }
}
