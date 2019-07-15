package com.javarush.task.task20.task2025;


import javax.management.ObjectName;
import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    public static int getCountsOfDigits(long number) {
        int count = (number == 0) ? 1 : 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }
    public static int [] getDigits (long digit, int numDigit) {
        int [] n = new int [numDigit];
        for (int i=0;i<numDigit;i++) {
            n[i] = (int) digit%(10);
            digit=digit/10;
        }
        return n;
    }

    public static long getDegreeSumm (int [] n) {
        long degreeSumm=0;
        for (int i = 0;i< n.length; i++){
            degreeSumm+=Math.pow(n[i],n.length);
        }
        return degreeSumm;
    }

    public static boolean checkAmstrong (long N) {
        int countDigit = getCountsOfDigits(N);
        int [] n = new int [countDigit];
        n = getDigits(N,countDigit);
        int degreeSumm=0;
        for (int i = 0; i<n.length;i++) {
            degreeSumm+= Math.pow(n[i],countDigit);
        }
        return degreeSumm==N;
    }

    public static long[] getNumbers(long N) {
        long[] result = null;
        int [] a = new int [20];
        Long [][] degree = new Long[50000][19];
        ArrayList<Long> arrayList= new ArrayList<>(), arrayListAll = new ArrayList<>();
        int i=0;
        while (i<N) {
            int countDigit = getCountsOfDigits(i);
            a = getDigits(i, countDigit);
            boolean checkDig=true;
            for (int j = 0; j<countDigit-1; j++) {
                if (a[j+1]<a[j]) checkDig = false;
            }
            long degreeSumm;
            if (checkDig) {
                if (degree[i][countDigit]==null) {
                    degreeSumm = getDegreeSumm(a);
                    degree[i][countDigit] = degreeSumm;
                }
                else degreeSumm=degree[i][countDigit];
            if (!arrayListAll.contains(degreeSumm)) {
                arrayListAll.add(degreeSumm);
                boolean digitIsAmstrong = checkAmstrong(degreeSumm);
                if (digitIsAmstrong && !arrayList.contains(degreeSumm)) arrayList.add(degreeSumm);
            }
            }

            i++;
        }
        result = new long[arrayList.size()];
        Collections.sort(arrayList);
        for (i =0; i < arrayList.size(); i++)
            result[i] = arrayList.get(i);
        return result;
    }


    public static void main(String[] args) {
        long[] result = new long[1000];
        result = getNumbers(Long.MAX_VALUE);
        for (long l: result
             ) {
            System.out.println(l);
        }
        System.out.println(Long.MAX_VALUE);

    }
}
