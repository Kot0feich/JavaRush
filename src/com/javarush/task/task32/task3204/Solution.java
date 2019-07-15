package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        final int passwordSize=8;
        Random random = new Random();
        int sizeUp=(new Random()).nextInt(passwordSize-3)+1;
        int sizeDown=(new Random()).nextInt((passwordSize-sizeUp-1))+1;
        int sizeDigit=passwordSize-sizeUp-sizeDown;
        ArrayList<Integer> ints = new ArrayList<>();
        byte [] randomPassword = new byte [passwordSize];
        for (int i=0;i<sizeUp;i++) {
            ints.add(random.nextInt(26)+'A');
        }
        for (int i=0;i<sizeDown;i++) {
            ints.add(random.nextInt(26)+'a');
        }
        for (int i=0;i<sizeDigit;i++) {
            ints.add(random.nextInt(10)+'0');
        }

        for (int i=0;i<passwordSize;i ++)
        {
            int index = random.nextInt(ints.size());
            Integer integerObject = new Integer (ints.get(index));
            randomPassword[i] = integerObject.byteValue();
            ints.remove(index);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            outputStream.write(randomPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream;
    }
}