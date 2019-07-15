package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by korobovav on 04.07.2017.
 */
public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();


        //напишите тут ваш код
        map.put("Andrey1", new Date(78, 0, 1));
        map.put("Andrey2", new Date(78, 1, 2));
        map.put("Andrey3", new Date(78, 2, 3));
        map.put("Andrey4", new Date(78, 3, 4));
        map.put("Andrey5", new Date(78, 4, 5));
        map.put("Andrey6", new Date(78, 5, 6));
        map.put("Andrey7", new Date(78, 6, 7));
        map.put("Andrey8", new Date(78, 7, 8));
        map.put("Andrey9", new Date(78, 8, 9));
        map.put("Andrey10", new Date(78, 9, 10));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator <HashMap.Entry <String,Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry <String, Date> pair = iterator.next();
            if (pair.getValue().getMonth()>4 && pair.getValue().getMonth()<8) iterator.remove();
        }

    }

    public static void main(String[] args) {
        HashMap <String,Date> hashMap = new HashMap<>();
        hashMap = createMap();
        removeAllSummerPeople(hashMap);
        Iterator <HashMap.Entry <String,Date>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<String, Date> pair = iterator.next();
            System.out.println(pair.getKey()+" "+pair.getValue() + " " + pair.getValue().getMonth());
        }

    }
}
