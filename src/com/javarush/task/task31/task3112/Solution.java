package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("http://bk/img/bk2017/icons/logo-first.jpg", Paths.get("D:/MyDownloads"));

        /*for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }*/
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        Path tmp = Paths.get(url.getPath()).getFileName();
        Path tempPath = Files.createTempFile("tmp-",".tmp");
        Files.copy(inputStream,tempPath, StandardCopyOption.REPLACE_EXISTING);
        Path result = Paths.get(downloadDirectory.toString()+"\\"+tmp);
        Files.move(tempPath,result);

        return result;
    }
}
