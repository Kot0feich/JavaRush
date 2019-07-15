package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.util.Locale.ENGLISH;

/*
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Rubi");
            user.setLastName("Rail");
            //user.setBirthDate(new Date (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss,SSS",Locale.ENGLISH).parse("01-01-1978 00:00:00,000").getTime()));
            user.setBirthDate(new Date(1508944516168L));
            user.setMale(true);
            user.setCountry(User.Country.OTHER);
            //user.printUser();

            User user1 = new User();
            user1.setFirstName("Rubi1");
            user1.setLastName("Rail1");
            //user1.setBirthDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("02-02-1979 00:00:00"));
            user1.setBirthDate(new Date(1508944516163L));
            user1.setMale(true);
            user1.setCountry(User.Country.OTHER);
            //user.printUser();

            javaRush.users.add(user);
            javaRush.users.add(user1);

            javaRush.save(outputStream);
            outputStream.flush();
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.hashCode());
            System.out.println(loadedObject.hashCode());
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            String usersIsNotEmpty = users.size()>0 ? "yes":"no";
            writer.write(usersIsNotEmpty + "\n");
            if (usersIsNotEmpty.equals("yes")) {
                for (int i=0;i<users.size();i++) {
                    writer.write(users.get(i).getFirstName() + ";" +
                            users.get(i).getLastName() + ";" +
                            users.get(i).getBirthDate().getTime() + ";" +
                            users.get(i).getCountry() + ";" +
                            users.get(i).isMale() + "\n");
                }

            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isNotEmpty = reader.readLine();
            if (isNotEmpty.equals("yes")) {
                String line;
                while ((line=reader.readLine())!=null) {
                    String [] loadUsers = line.split(";");
                    User user = new User();
                    user.setFirstName(loadUsers[0]);
                    user.setLastName(loadUsers[1]);
                    String strDate = loadUsers[2];
                    //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz YYYY", Locale.ENGLISH);
                    //user.setBirthDate(simpleDateFormat.parse(strDate));
                    user.setBirthDate(new Date(Long.parseLong(loadUsers[2])));
                    user.setCountry(User.Country.valueOf(loadUsers[3]));
                    user.setMale(Boolean.parseBoolean(loadUsers[4]));
                    users.add(user);
                   // user.printUser();
                }

            }


        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
