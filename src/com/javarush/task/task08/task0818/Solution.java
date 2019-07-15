package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by korobovav on 06.07.2017.
 */
public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap <String, Integer> hashMap = new HashMap<>();
        hashMap.put("Andrey1", 100);
        hashMap.put("Andrey2", 200);
        hashMap.put("Andrey3", 300);
        hashMap.put("Andrey4", 400);
        hashMap.put("Andrey5", 500);
        hashMap.put("Andrey6", 600);
        hashMap.put("Andrey7", 700);
        hashMap.put("Andrey8", 800);
        hashMap.put("Andrey9", 900);
        hashMap.put("Andrey10", 1000);
        return hashMap;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<HashMap.Entry <String,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            HashMap.Entry<String,Integer> pair = iterator.next();
            if (pair.getValue()<500) iterator.remove();
        }
    }

    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap=createMap();
        removeItemFromMap(hashMap);
        for (HashMap.Entry<String, Integer> pair : hashMap.entrySet()) {
            System.out.println(pair.getKey()+" "+pair.getValue());
        }

    }
}
