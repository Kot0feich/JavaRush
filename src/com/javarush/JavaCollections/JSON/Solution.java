package com.javarush.JavaCollections.JSON;

import java.io.IOException;
import java.io.StringWriter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //создание объекта для сериализации в JSON
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;

        //писать результат сериализации будем во Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //это объект Jackson, который выполняет сериализацию
        ObjectMapper mapper = new ObjectMapper();

        // сама сериализация: 1-куда, 2-что
        mapper.writeValue(writer, cat);

        //преобразовываем все записанное во StringWriter в строку
        String result = writer.toString();
        System.out.println(result);
        System.out.println("test");
    }
}
