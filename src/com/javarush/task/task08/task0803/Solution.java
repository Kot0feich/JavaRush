package com.javarush.task.task08.task0803;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by korobovav on 29.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        String[] cats = new String[]{"васька", "мурка", "дымка", "рыжик", "серый", "снежок", "босс", "борис", "визя", "гарфи"};

        HashMap<String, Cat> map = addCatsToMap(cats);

        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }


    public static HashMap<String, Cat> addCatsToMap(String[] cats) {
        //напишите тут ваш код
        HashMap <String, Cat> hashMap = new HashMap<String, Cat>();
        Cat [] cat = new Cat[cats.length];
        for (int i=0;i<cats.length;i++) {
            cat[i] = new Cat(cats[i]);
            hashMap.put(cats[i], cat[i]);
        }
        return hashMap;
    }


    public static class Cat {
        String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name != null ? name.toUpperCase() : null;
        }
    }
}
