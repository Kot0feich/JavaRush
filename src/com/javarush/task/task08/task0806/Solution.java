package com.javarush.task.task08.task0806;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by korobovav on 29.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("Sim", 5);
        map.put("Tom", 5.5);
        map.put("Arbus", false);
        map.put("Baby", null);
        map.put("Cat", "Cat");
        map.put("Eat", new Long(56));
        map.put("Food", new Character('3'));
        map.put("Gevey", '6');
        map.put("Hugs", 111111111111L);
        map.put("Comp", (double) 123);

        //напишите тут ваш код
        for (HashMap.Entry <String,Object> text : map.entrySet()) {
            System.out.println(text.getKey()+" - "+ text.getValue());
        }

    }
}
