package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

        //System.out.println("Параметры командной строки:");
        //for (String str: args) System.out.println(str);
        try {

            switch (args[0]) {
                case "-c": {
                    if (args.length==4) {
                        //System.out.println("Надо создать новую запись с именем " + args[1] + ", пол: " + args[2] + ", дата рождения: " + args[3]);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        Person person;
                        if (args[2].equals("м"))
                             person = Person.createMale(args[1], simpleDateFormat.parse(args[3]));
                        else
                            person = Person.createFemale(args[1], simpleDateFormat.parse(args[3]));
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                    break;
                }
                case "-u": {
                    if (args.length==5) {
                        //System.out.println("Надо обновить запись с ID " + args[1] + " на имя " + args[2] + ", пол: " + args[3] + ", дата рождения: " + args[4]);
                        int id = Integer.parseInt(args[1]);
                        String name = args [2];
                        Sex sex = (args[3].equals("м")) ? Sex.MALE : Sex.FEMALE;
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);;
                        Date date = simpleDateFormat.parse(args[4]);
                        allPeople.get(id).setName(name);
                        allPeople.get(id).setSex(sex);
                        allPeople.get(id).setBirthDate(date);
                    }
                    break;
                }
                case "-d": {
                    if (args.length == 2) {
                        System.out.println("Надо удалить запись с ID " + args[1]);
                        int id = Integer.parseInt(args[1]);
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setBirthDate(null);
                    }
                    break;
                }
                case "-i": {
                    if (args.length==2) {
                        //System.out.println("Надо вывести запись с ID " + args[1]);
                        Person person;
                        int id = Integer.parseInt(args[1]);
                        String name = allPeople.get(id).getName();
                        String sex = (allPeople.get(id).getSex()==Sex.MALE) ? "м" : "ж";
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);;
                        String date = simpleDateFormat.format(allPeople.get(id).getBirthDate());
                        System.out.println(name + " " + sex + " " + date);
                    }
                    break;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /*for (int i = 0; i<allPeople.size();i++) {
            System.out.println(i+ " " + allPeople.get(i).getName() + " " + allPeople.get(i).getSex() + " " + allPeople.get(i).getBirthDate());
        }*/
    }

}
