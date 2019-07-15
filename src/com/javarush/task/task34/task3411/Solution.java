package com.javarush.task.task34.task3411;

/*
Ханойские башни
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception{
        int numRings = 3;
        System.out.println("A - from that ring");
        System.out.println("B - to that ring");
        System.out.println("C - intermediate ring");
        System.out.print("Input a ring number: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        numRings = Integer.parseInt(reader.readLine());
        moveRing('A', 'B', 'C', numRings);
        System.out.println("Press any key");
        reader.readLine();
    }

    public static void moveRing(char a, char b, char c, int numRings) {
        //напишите тут ваш код
        if (numRings == 1) {
            System.out.println("from " + a +" to " + b);
        }
        else
        {
            moveRing(a,c,b,numRings-1);
            System.out.println("from " + a +" to " + b);
            moveRing(c,b,a,numRings-1);
        }
    }
}