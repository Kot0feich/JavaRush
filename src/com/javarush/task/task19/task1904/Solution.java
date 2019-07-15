package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws Exception{
        String fileName = "d:\\a.txt";
        Scanner scanner = new Scanner(new File(fileName));
        PersonScanner personScanner = new PersonScannerAdapter(scanner);
        System.out.println(personScanner.read().toString());
        scanner.close();

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Person person;
            String str="";
            if (fileScanner.hasNext()) str=fileScanner.nextLine();
            Pattern pattern = Pattern.compile(" ");
            String[] splitStr = pattern.split(str);
            String lastName = splitStr[0];
            String firstName = splitStr[1];
            String middleName = splitStr[2];
            Date date= new Date(Integer.parseInt(splitStr[5])-1900, Integer.parseInt(splitStr[4])-1, Integer.parseInt(splitStr[3]));
            person = new Person(firstName, middleName, lastName, date);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
