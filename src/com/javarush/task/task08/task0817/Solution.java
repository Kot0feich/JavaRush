package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * Created by korobovav on 05.07.2017.
 */
public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap <String, String> hashMap = new HashMap<>();
        hashMap.put("Иванов", "Иван");
        hashMap.put("Иванов1", "Иван1");
        hashMap.put("Иванов2", "Иван");
        hashMap.put("Иванов3", "Иван2");
        hashMap.put("Иванов4", "Иван");
        hashMap.put("Иванов5", "Иван4");
        hashMap.put("Иванов6", "Иван01");
        hashMap.put("Иванов7", "Иван7");
        hashMap.put("Иванов8", "Иван01");
        hashMap.put("Иванов9", "Иван9");
        hashMap.put("Иванов10", "Иван");
        return hashMap;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        HashMap <String,String> hashMap=new HashMap<>();
        hashMap.putAll(map);
        Iterator <HashMap.Entry<String,String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<String,String> pair = iterator.next();
            int count = 0;
            for (HashMap.Entry<String,String> mapPair : hashMap.entrySet()) {
                //System.out.println(hashMapPair.getKey()+" "+ hashMapPair.getValue());
                if (mapPair.getValue().equals(pair.getValue())) count++;
            }
            if (count>1) {
               // System.out.println("найден дубль: "+pair.getValue());
                removeItemFromMapByValue(map, pair.getValue());
            }

        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap <String, String> hashMap = new HashMap<>();
        hashMap=createMap();
        removeTheFirstNameDuplicates(hashMap);
        for (HashMap.Entry<String,String> pair : hashMap.entrySet()) {
            System.out.println(pair.getKey()+" "+pair.getValue());
        }

    }
}
