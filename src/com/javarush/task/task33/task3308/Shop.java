package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.LinkedList;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
class Shop {
    static class Goods {
        @XmlAnyElement
        public List<String> names = new LinkedList<>();
    }

    public Goods goods;
    public int count;
    public double profit;
    public String [] secretData;
}
