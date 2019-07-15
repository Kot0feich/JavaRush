package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("D:\\MyData\\Documents\\IdeaProjects\\JavaRush\\src\\com\\javarush\\task\\task31\\task3109\\properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("D:\\MyData\\Documents\\IdeaProjects\\JavaRush\\src\\com\\javarush\\task\\task31\\task3109\\properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("D:\\MyData\\Documents\\IdeaProjects\\JavaRush\\src\\com\\javarush\\task\\task31\\task3109\\test");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {

        //создаем объект Properties
        Properties properties = new Properties();
        try {

            //и загружаем в него данные из файла.
            if (fileName.contains(".xml")) {
                properties.loadFromXML(new FileInputStream(fileName));
            } else {
                properties.load(new FileReader(new File(fileName)));
            }
            //проходимся по всем ключам и печатаем все их значения на консоль
            /*for (String key : properties.stringPropertyNames())
            {
                System.out.println(properties.get(key));
            }*/
            return properties;
        } catch (IOException e) {
            return properties;
        }
    }
}
