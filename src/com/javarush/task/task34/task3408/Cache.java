package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K, V> ();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        //System.out.println("  clazz = " + clazz);
        //Class myClass = key.getClass();
        //Получить перечень полей с помощью рефлексии
        /*try {

            System.out.println("MyClass = " + myClass);
            Field[] fields = myClass.getDeclaredFields();
            for(int i = 0; i < fields.length; i++) {
               // System.out.println("Field = " + fields[i].toString());
            }
            Method[] methods = myClass.getDeclaredMethods();
            for(int i = 0; i < methods.length; i++) {
               // System.out.println("Metod = " + methods[i].toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        // получить список коснтрукторов
        try {
            if (cache.get(key)==null) {
                Constructor constructor = clazz.getDeclaredConstructor(key.getClass());
                //System.out.println("Constructor = " + constructor);
                V obj = (V) constructor.newInstance(key);
                cache.put(key, obj);
            }
        } catch (NoSuchMethodException e) {

        }
        return cache.get(key);
    }

    public boolean put(V obj) {
        //TODO add your code here
                int size = size();
        Class cl = obj.getClass();
        try {
            Method method = cl.getDeclaredMethod("getKey",null);
            method.setAccessible(true);
            K k = (K) method.invoke(obj,null);
            cache.put(k,obj);
            if (size()<=size) return false;
            else return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
