package com.javarush.task.task09.task0911;

import java.util.HashMap;

/**
 * Created by korobovav on 20.07.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            //напишите тут ваш код

            HashMap<String, String> map = new HashMap<String, String>(null);
            map.put(null, null);
            map.remove(null);

            //напишите тут ваш код
        } catch (NullPointerException e) {
            System.out.println(e.getClass().getTypeName());
        }
    }
}
