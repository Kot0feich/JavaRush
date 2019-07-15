package com.javarush.task.task35.task3507;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Set;

/*
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        System.out.println(pathToAnimals);

        File[] files = new File(pathToAnimals).listFiles();

        ArrayList list = new ArrayList();

        for (int i=0;i<files.length;i++) System.out.println(files[i]);
        /**
         * Создаем загрузчик модулей.
         */
        ModuleLoader moduleLoader = new ModuleLoader(pathToAnimals,ClassLoader.getSystemClassLoader());
        /**
         * Получаем список доступных модулей.
         */
        File dir = new File (pathToAnimals);
        String[] modules = dir.list();
        System.out.println(dir);
        for (String s: dir.list()) {
            System.out.println(s);
            try {
                //вытащим название класса из имени фала
                String moduleName = s.split(".class")[0];
                System.out.println(moduleName);
                ClassLoader loader = new ClassLoader() {
                    @Override
                    public Class<?> findClass(String className) throws ClassNotFoundException {
                        try {
                            byte b[] = fetchClassFromFS(pathToAnimals + className + ".class");
                            return defineClass(null, b, 0, b.length);
                        }
                        catch (FileNotFoundException ex) {
                            return super.findClass(className);
                        }
                        catch (IOException ex) {
                            return super.findClass(className);
                        }
                    }
                };
                Class clazz = loader.loadClass(moduleName);
                Class[] interfaces = clazz.getInterfaces();
                boolean hasInterface = false;
                for(Class i : interfaces) {
                    if(Animal.class.equals(i)) {
                        hasInterface = true;
                        //break;
                        System.out.println("Animal.class = " + Animal.class);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }



    private static byte[] fetchClassFromFS(String path) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(new File(path));

        // Get the size of the file
        long length = new File(path).length();

        if (length > Integer.MAX_VALUE) {
            // File is too large
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+path);
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;

    }
}
