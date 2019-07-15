package com.javarush.task.task19.task1917;

/*
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;
    private char[] cbuf;
    int off,len,c;
    String str="";

       public FileConsoleWriter (String fileName) throws Exception{
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter (String fileName, boolean append) throws Exception{
        this.fileWriter = new FileWriter(fileName,append);
    }

    public FileConsoleWriter(File file) throws Exception{
        this.fileWriter = new FileWriter(file);
    }
    public FileConsoleWriter(File file, boolean append) throws Exception{
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter (FileDescriptor fd){
        this.fileWriter = new FileWriter(fd);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
           fileWriter.write(cbuf, off, len);
        System.out.print(String.valueOf(cbuf).toString().substring(off,off+len));
    }

    public void write(int c) throws IOException {
        this.fileWriter.write(c);
        System.out.print(c);

    }
    public void write(String str) throws IOException {
        this.fileWriter.write(str);
        System.out.print(str);

    }
    public void write(String str, int off, int len)  throws IOException {
        fileWriter.write(str, off, len);
        System.out.print(str.substring(off,off+len));

    }
    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.print(String.valueOf(cbuf).toString());
    }
    public void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) throws Exception{
    }

}
