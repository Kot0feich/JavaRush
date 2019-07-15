package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/*
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
/*        Map <String,String> map = new HashMap<>();
        map.put("name","asdasd");
        map.put("country","asdasdasd");
        map.put("city","asdasdasd");
        map.put("age",null);
        System.out.println(getQuery(map));*/
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();

            for (Map.Entry<String,String> entry: params.entrySet()) {
                if (entry.getValue() != null) {
                    if (stringBuilder.length()==0) stringBuilder.append(entry.getKey() + " = '" + entry.getValue() + "'");
                    //else if (entry.getValue()!=null) stringBuilder.append(" and "+entry.getKey()+"='"+entry.getValue()+"'");
                    else
                        stringBuilder.append(String.format("%s%s%s%s%s", " and ", entry.getKey(), " = '", entry.getValue(), "'"));
            }
        }
        return stringBuilder.toString();
    }
}
