package com.javarush.JavaCollections.viewArrayList;

import java.util.Arrays;
        import java.util.Iterator;
        import java.util.List;

/**
 * Created by danil.kuznetsov
 */
public class Solution {
    public static void main(String... args) {

        List<String> colors = Arrays.asList("red", "yellow",  "blue", "black", "orange", "white","green");

        // Basic loop
        for (int i = 0; i < colors.size(); i++) {
            String color = colors.get(i);
            printItemList(color);
        }


        // foreach
        for (String color : colors) {
            printItemList(color);
        }

        // Basic loop with iterator
        for (Iterator<String> it = colors.iterator(); it.hasNext(); ) {
            String color = it.next();
            printItemList(color);
        }

        // Iterator with while loop
        Iterator<String> it = colors.iterator();
        while (it.hasNext()) {
            String color = it.next();
            printItemList(color);
        }

        // JDK 8 streaming example lambda expression
        colors.stream().forEach(color -> printItemList(color));

        // JDK 8 streaming example method reference
        colors.stream().forEach(Solution::printItemList);

        // JDK 8 for each with lambda
        colors.forEach(color -> printItemList(color));

        // JDK 8 for each
        colors.forEach(Solution::printItemList);
    }

    private static void printItemList(String color) {
        System.out.println("color: " + color);
    }

}