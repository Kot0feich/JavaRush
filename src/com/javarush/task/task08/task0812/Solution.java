package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by korobovav on 30.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList <Integer> arrayList = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<10;i++) {
            arrayList.add(Integer.parseInt(reader.readLine()));
        }
        int maxSeq = 1;
        int maxSeqFinal = 1;
        for (int i=0;i<arrayList.size();i++) {
            if (i<arrayList.size()-1) {
                int prev=arrayList.get(i);
                int next=arrayList.get(i+1);
                if (prev==next) maxSeq++;
                else {
                    if (maxSeqFinal<maxSeq) maxSeqFinal=maxSeq;
                    maxSeq=1;
                }
            }
            else {
                if (maxSeqFinal<maxSeq) maxSeqFinal=maxSeq;
            }
        }
        System.out.println(maxSeqFinal);
    }

}
