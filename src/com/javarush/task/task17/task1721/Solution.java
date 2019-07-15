package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameAllLines = reader.readLine();
        String fileNameForRemoveLines = reader.readLine();

        BufferedReader freaderAllLines = new BufferedReader(new InputStreamReader(new FileInputStream(fileNameAllLines)));
        String readLine;
        while ((readLine = freaderAllLines.readLine())!= null) allLines.add(readLine);
        BufferedReader freaderForRemoveLines = new BufferedReader(new InputStreamReader(new FileInputStream(fileNameForRemoveLines)));
        while ((readLine=freaderForRemoveLines.readLine())!=null) forRemoveLines.add(readLine);
        Solution solution = new Solution();
        solution.joinData();
        freaderAllLines.close();
        freaderForRemoveLines.close();


    }

    public void joinData () throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines))
        {
            for (int i=0; i < allLines.size(); i++) {
                if (forRemoveLines.contains(allLines.get(i))) allLines.remove(i);
            }
        }
        else {
            allLines.clear();
            throw new CorruptedDataException ();
        }
    }
}
