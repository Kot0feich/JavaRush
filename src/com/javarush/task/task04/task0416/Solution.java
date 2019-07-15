package com.javarush.task.task04.task0416;

/*
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double v = Double.parseDouble(reader.readLine());
        if (v>5) v%=5;
        //System.out.println(v);
        if (v==5) v=0;
        if (v>=0 && v<3) System.out.println("зелёный");
        if (v>=3 && v<4) System.out.println("жёлтый");
        if (v>=4 && v<5) System.out.println("красный");
    }
}