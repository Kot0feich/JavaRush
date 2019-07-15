package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        /*System.out.println("Параметры командной строки:");
        for (String str: args) System.out.println(str);*/
        try {
            switch (args[0]) {

                case "-c": {
                    synchronized (allPeople) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        for (int i = 1; i < args.length; i += 3) {
                            String name = args[i];
                            Sex sex = (args[i + 1].equals("м")) ? Sex.MALE : Sex.FEMALE;
                            Date date = simpleDateFormat.parse(args[i + 2]);
                            if (sex.equals(Sex.MALE)) allPeople.add(Person.createMale(name, date));
                            else allPeople.add(Person.createFemale(name, date));
                            System.out.println(allPeople.size() - 1);
                        }
                        break;
                    }
                }
                case  "-u" : {
                    synchronized (allPeople) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy", Locale.ENGLISH);
                        for (int i = 1; i < args.length; i += 4) {
                            int id = Integer.parseInt(args[i]);
                            String name = args[i + 1];
                            Sex sex = (args[i + 2].equals("м")) ? Sex.MALE : Sex.FEMALE;
                            Date date = simpleDateFormat.parse(args[i + 3]);
                            allPeople.get(id).setName(name);
                            allPeople.get(id).setSex(sex);
                            allPeople.get(id).setBirthDate(date);
                        }
                        break;
                    }
                }
                case "-d": {
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            int id = Integer.parseInt(args[i]);
                            allPeople.get(id).setName(null);
                            allPeople.get(id).setSex(null);
                            allPeople.get(id).setBirthDate(null);
                        }
                        break;
                    }
                }
                case "-i": {
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            int id = Integer.parseInt(args[i]);
                            String name = allPeople.get(id).getName();
                            String sex = (allPeople.get(id).getSex() == Sex.MALE ? "м" : "ж");
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                            String date = simpleDateFormat.format(allPeople.get(id).getBirthDate());
                            System.out.println(name + " " + sex + " " + date);
                        }
                    }
                }


            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
       /*   for (int i = 0; i<allPeople.size();i++) {
            System.out.println(i+ " " + allPeople.get(i).getName() + " " + allPeople.get(i).getSex() + " " + allPeople.get(i).getBirthDate());
        }*/
    }
}
