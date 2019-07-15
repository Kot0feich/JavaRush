package com.javarush.task.task15.ebcdic;

import com.javarush.task.task15.task1525.Statics;

import java.io.*;
import java.nio.charset.Charset;


/**
 * Created by korobovav on 09.06.2018.
 */
public class solution {
    public static void main(String[] args) throws Exception {
        InputStreamReader rdr = new InputStreamReader(new FileInputStream("C:\\test.txt"), Charset.forName("ASCII"));
        BufferedReader reader = new BufferedReader(rdr);
        String line;
        while(( line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
