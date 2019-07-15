package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/*
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();
    static {

    }

    public static void main(String[] args) throws Exception{
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        Pattern pattern = Pattern.compile(" ");
        String str="";
        while ((str=fileReader.readLine())!=null) {
            String[] splitStr = pattern.split(str);
            int splitSize = splitStr.length-1;
            Integer year = Integer.parseInt(splitStr[splitSize])-1900;
            Integer mounth = Integer.parseInt(splitStr[splitSize-1])-1;
            Integer day = Integer.parseInt(splitStr[splitSize-2]);
            Date date = new Date(year,mounth,day);
            String fullName = "";
            for (int i=0;i<splitSize-2;i++) fullName+=splitStr[i]+" ";

            //System.out.println(fullName + date.toString());
            PEOPLE.add(new Person(fullName.trim(), date));
        }
        fileReader.close();
        for (Person people : PEOPLE) {
            System.out.println(people.getBirthDate() + " " + people.getName());
        }

    }
}
