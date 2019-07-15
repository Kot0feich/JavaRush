package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.KeyStore;
import java.util.*;

public class AmigoSet <E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }
    public AmigoSet(Collection<? extends E> collection) {
        int round = (int) Math.ceil(collection.size()/.75f);
        int Capacity = Math.max((int) (collection.size()/.75f) + 1, 16);
        this.map = new HashMap<>(Capacity);
        for (E e : collection) {
            map.put(e, PRESENT);
        }
       //map.putAll();
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }


    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(Object o) {
        return null==map.put((E) o, PRESENT);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        map.remove(o);
        return true;
    }

    @Override
    public Object clone() {
        try {
            AmigoSet copy = (AmigoSet)super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        out.writeObject(capacity);
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map,"loadFactor");
        out.writeObject(loadFactor);
        int size = map.size();
        out.writeObject(size);
        for (E e:map.keySet()) {
            out.writeObject(e);
        }


    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int capacity = (int) in.readObject();
        float loadFactor = (float) in.readObject();
        int size = (int) in.readObject();
        map = new HashMap<>(capacity, loadFactor);
        for (int i=0;i<size;i++) {
            E e = (E) in.readObject();
            map.put(e,PRESENT);
        }






    }

}
