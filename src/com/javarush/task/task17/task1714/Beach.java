package com.javarush.task.task17.task1714;

/*
Comparable
*/

public class Beach implements Comparable <Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    @Override
    synchronized public int compareTo(Beach o) {
        float k = this.quality/this.distance - o.quality/o.distance;
        if (k==0) return 0;
        if (k>0) return 1;
        else return -1;


    }

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    synchronized public String getName() {
        return name;
    }

    synchronized public void setName(String name) {
        this.name = name;
    }

    synchronized public float getDistance() {
        return distance;
    }

    synchronized public void setDistance(float distance) {
        this.distance = distance;
    }

    synchronized public int getQuality() {
        return quality;
    }

    synchronized public void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }
}
