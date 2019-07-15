package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    private FileOutputStream outputStream;

/*    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    public void write(byte[] b) throws IOException {
        outputStream.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        outputStream.write(b, off, len);
    }

    public void flush() throws IOException {
        outputStream.flush();
    }
    public void close () throws IOException {
        outputStream.close();
    }*/

    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException, IOException {
        super(fileName);
        if (!fileName.endsWith(".txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        }
        else this.outputStream = outputStream;
    }

    public static void main(String[] args) {
    }
}

