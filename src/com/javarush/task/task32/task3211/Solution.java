package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/*
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        //Создаем объект MessageDigest
        MessageDigest md = MessageDigest.getInstance("MD5");
        //Передаем данные в созданный объект MessageDigest
        md.update(byteArrayOutputStream.toByteArray());
        //Генерируем дайджест сообщения
        byte[] digest = md.digest();
        //Converting the byte array in to HexString format
        StringBuffer hexString = new StringBuffer();
        for (int i = 0;i<digest.length;i++) {
            //hexString.append(Integer.toHexString(0xFF & digest[i]));
            String s = Integer.toHexString(0xff & digest[i]);
            s = (s.length() == 1) ? "0" + s : s;
            hexString.append(s);
        }

       /* System.out.println(String.format("  %s", hexString.toString()));
        System.out.println(String.format("  %s", md5));*/

        return hexString.toString().equals(md5);
    }
}
