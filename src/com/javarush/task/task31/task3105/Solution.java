package com.javarush.task.task31.task3105;



import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0], zipName=args[1];

        FileInputStream zipInFile = new FileInputStream(zipName);
        ZipInputStream zipInputStream = new ZipInputStream(zipInFile);
        ZipEntry entry;
        //для хранения имени файла и его содержимого
        Map<String, byte[]> zipMap = new HashMap<>();
        //бежим по файлам массива
        while((entry = zipInputStream.getNextEntry()) != null)
        {
            //System.out.println(entry.getName() + " - " + entry.getSize());
            //подготавливаем большой ассив для записи в мапу
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i=0;
            byte [] bytes = new byte[1024];
            while ((i=zipInputStream.read(bytes))!=-1) byteArrayOutputStream.write(bytes,0,i);
            zipMap.put(entry.getName(),byteArrayOutputStream.toByteArray());

        }
        zipInputStream.close();
        //for (Map.Entry<String,byte[]> entryEntry : zipMap.entrySet()) System.out.println(entryEntry.getKey()+" "+entryEntry.getValue().length);

        // создаем архив
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipName));
       //кладем в него ранее сохраненные файлы
        for (Map.Entry<String ,byte[]> entryZipMap : zipMap.entrySet()) {
            if (("new\\"+Paths.get(fileName).getFileName().toString()).equals(entryZipMap.getKey())) continue;
            zipOutputStream.putNextEntry(new ZipEntry(entryZipMap.getKey()));
            zipOutputStream.write(entryZipMap.getValue(),0,entryZipMap.getValue().length);
            zipOutputStream.closeEntry();
        };
        //кладем в него ZipEntry – «архивный объект»
        //предварительно получим имя файла из полного пути
        zipOutputStream.putNextEntry(new ZipEntry("new\\"+Paths.get(fileName).getFileName().toString()));
        //копируем файл fileName в архив под именем fileName
        File file = new File(fileName);
        Files.copy(file.toPath(), zipOutputStream);

        zipOutputStream.close();
    }
}
