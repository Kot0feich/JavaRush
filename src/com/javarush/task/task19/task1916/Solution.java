package com.javarush.task.task19.task1916;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = "d:\\a.txt";//reader.readLine();
        String nameFile2 = "d:\\b.txt";//reader.readLine();
        reader.close();
        BufferedReader fileReader1 = new BufferedReader(new FileReader(nameFile1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(nameFile2));
        String str1="", str2 = "";
        List <String> list1 = new ArrayList<>();
        List <String> list2 = new ArrayList<>();
        while ((str1=fileReader1.readLine())!=null)
        {
            list1.add(str1);
        }
        fileReader1.close();
        while ((str2=fileReader2.readLine())!=null)
        {
            list2.add(str2);
        }
        fileReader2.close();
        int i=0;
        while (i<max (list1.size(),list2.size())) {
            LineItem item;
            if (i < min(list1.size(), list2.size())) {
                if (!list1.get(i).equals(list2.get(i))) {
                    if (!list1.get(i).equals(list2.get(i - 1))
                            &&
                            !list1.get(i).equals(list2.get(i + 1))) {
                        list2.add(i, "");
                        lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    } else {
                        list1.add(i, "");
                        lines.add(new LineItem(Type.ADDED, list2.get(i)));
                    }
                } else lines.add(new LineItem(Type.SAME, list1.get(i)));

            }
            else {
                if (list1.size()>list2.size()) lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                else lines.add(new LineItem(Type.ADDED, list2.get(i)));
            }
            i++;
        }

        System.out.println(list1);
        System.out.println(list2);
        for (LineItem lineItem : lines) {
            System.out.println(lineItem.line +" " + lineItem.type);
        }
    }

    public static int min(int a, int b) {
            return a < b ? a : b;
    }

    private static int max(int size, int size1) {
        return (size1>size ? size1 : size);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
