package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;



/*
Проход по дереву файлов
*/
public class Solution {
    List<File> arrayList = new ArrayList<>();

    public void processFilesFromFolder(File folder) {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                processFilesFromFolder(entry);
                continue;
            }
            /*entry.getName().matches(".*\\.txt") &*/
            if (entry.length()<=50) arrayList.add(entry);
        }
    }

    public static void main(String[] args) throws Exception{
        //String path = args[0];
        //String resultFileAbsolutePath = args[1];
        Solution solution = new Solution();
        File path = new File(args[0]);
        solution.processFilesFromFolder(path);
        Collections.sort(solution.arrayList, Comparator.comparing(File::getName));

        File resultFileAbsolutePath = new File(args[1]);
        File newFile = new File(resultFileAbsolutePath.getParentFile() + "/allFilesContent.txt");
        //if (FileUtils.isExist(newFile)) FileUtils.deleteFile(newFile);
        FileUtils.renameFile(resultFileAbsolutePath, newFile);
        FileWriter fileWriter = new FileWriter(newFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < solution.arrayList.size(); i++) {
            FileReader fileReader = new FileReader(solution.arrayList.get(i));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String inStr="";
            while ((inStr=bufferedReader.readLine())!=null) {
                bufferedWriter.write(inStr+"\n");
            }
//            bufferedWriter.write("\n");
            bufferedReader.close();
        }
        bufferedWriter.close();
    }
}
