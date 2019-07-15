package com.javarush.task.task08.task0802;

import java.util.HashMap;
import java.util.jar.Pack200;

/**
 * Created by korobovav on 28.06.2017.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap <String, String> hashMap = new HashMap<String, String>();
        hashMap.put("арбуз", "ягода");
        hashMap.put("банан","трава");
        hashMap.put("вишня","ягода");
        hashMap.put("груша","фрукт");
        hashMap.put("дыня","овощ");
        hashMap.put("ежевика","куст");
        hashMap.put("жень-шень","корень");
        hashMap.put("земляника","ягода");
        hashMap.put("ирис","цветок");
        hashMap.put("картофель","клубень");
        for (HashMap.Entry <String, String> text : hashMap.entrySet()) {
            System.out.println(text.getKey()+"-"+text.getValue());
        }
    }
}
