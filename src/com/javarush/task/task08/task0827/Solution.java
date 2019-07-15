package com.javarush.task.task08.task0827;

import java.util.Date;

/**
 * Created by korobovav on 12.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("JAN 2 2013"));
        System.out.println(isDateOdd("MAY 2 2013"));
        System.out.println(isDateOdd("JANUARY 1 2000"));
    }
    public static boolean isDateOdd (String date) {
        Date currDate = new Date(date);
        Date beginDate = new Date(currDate.getYear(),0,1);
        long msTimeDistance =currDate.getTime()-beginDate.getTime();
        long msDay = 24 * 60 * 60 * 1000;
        int dayCount = (int) (msTimeDistance/msDay);
        if (dayCount%2==0) return true;
        else return false;    }
}
