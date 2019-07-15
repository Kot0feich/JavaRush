package com.javarush.task.task31.task3106;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws Exception{
        String [] partNames = new String[args.length-1];
        for (int i=1;i<args.length;i++) partNames[i-1]=args[i];
        Arrays.sort(partNames);
        //for (int i=0;i<partNames.length;i++) System.out.println(partNames[i]);
        List<FileInputStream> fileInputStreams = new ArrayList<>();
        for (int i=0;i<partNames.length;i++) fileInputStreams.add(new FileInputStream(partNames[i]));
        Iterator<FileInputStream> fileInputStreamIterator = fileInputStreams.iterator();
        Enumeration<FileInputStream> fileInputStreamEnumeration = Collections.enumeration(fileInputStreams);

        SequenceInputStream sequenceInputStream = new SequenceInputStream(fileInputStreamEnumeration);
        ZipInputStream zipInputStream = new ZipInputStream(sequenceInputStream);
        ZipEntry entry;
        try {
            //for(ZipEntry entry = null; (entry = zipInputStream.getNextEntry()) != null; ) {
            while ((entry = zipInputStream.getNextEntry())!=null) {
                FileOutputStream fileOutputStream = new FileOutputStream(args[0]);
                OutputStream outputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    for(int readBytes = -1; (readBytes = zipInputStream.read(buffer, 0, bufferSize)) > -1; ) {
                        outputStream.write(buffer, 0, readBytes);
                    }
                    outputStream.flush();
                } finally {
                    outputStream.close();
                }
            }
        } finally {
            zipInputStream.close();
        }


    }
}

