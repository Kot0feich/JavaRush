package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws Exception{
        System.out.println(new Solution(4));
        Solution savedObject = new Solution(20);

        File your_file_name = File.createTempFile("your_file_name", null);

        FileOutputStream outputStream = new FileOutputStream(your_file_name);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(savedObject);
        System.out.println(savedObject.string);

        FileInputStream inputStream = new FileInputStream(your_file_name);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Solution loadedObject  = (Solution) objectInputStream.readObject();
        System.out.println(loadedObject.string);


    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }
}
