package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "D:\\a.txt";//reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String inStr="";
        String[] words;
        HashMap<String,String> hashMap = new HashMap<>();
        while ((inStr=fileReader.readLine())!=null) {
            StringBuilder stringBuilder = new StringBuilder(inStr);
            words = inStr.split("\\s");
            for (String word:words) {
                String reverseWord =  new StringBuilder(word).reverse().toString();
                if (hashMap.containsKey(reverseWord)) hashMap.put(reverseWord,word);
                else hashMap.put(word,"");
            }
        }
        for (HashMap.Entry <String,String> entry : hashMap.entrySet()) {
            if (!entry.getValue().equals("")) {
                Pair pair = new Pair();
                pair.first = entry.getKey();
                pair.second = entry.getValue();
                result.add(pair);
            }

            //for (int i = 0;i<result.size();i++)
                //System.out.println(result.get(i).first + " " + result.get(i).second);
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
