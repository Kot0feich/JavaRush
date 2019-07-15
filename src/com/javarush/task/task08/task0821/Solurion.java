package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by korobovav on 10.07.2017.
 */
public class Solurion {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map <String,String> map = new HashMap<>();
        map.put("Ivanov1","Ivan1");
        map.put("Ivanov2","Ivan2");
        map.put("Ivanov3","Ivan3");
        map.put("Ivanov4","Ivan4");
        map.put("Ivanov5","Ivan5");
        map.put("Ivanov6","Ivan6");
        map.put("Ivanov7","Ivan7");
        map.put("Ivanov8","Ivan8");
        map.put("Ivanov9","Ivan2");
        map.put("Ivanov1","Ivan10");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
