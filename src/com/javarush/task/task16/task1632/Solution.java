package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new thread1());
        threads.add(new thread2());
        threads.add(new thread3());
        threads.add(new thread4());
        threads.add(new thread5());
    }
    public static class thread1 extends Thread {
        public void run () {
            do {
            }
            while (true);
        }
    }
    public static class thread2 extends Thread {
        public void run () {
                do {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                  }
            } while (true);
        }
    }
    public static class thread3 extends Thread {
        public void run () {
            try {
                while (!interrupted()) {
                System.out.println("Ура");
                sleep(500); }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static class thread4 extends Thread implements Message{
        public void run () {
            while (!this.interrupted()) {}

        }
        public void showWarning () {
            this.interrupt();
        }
    }
    public static class thread5 extends Thread {
        public void run () {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str="";
            Integer summ=0;
            while (!str.equals("N")) {
                try {
                    str=reader.readLine();
                    if (!str.equals("N")) summ+=Integer.parseInt(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(summ);
        }
    }

    public static void main(String[] args) {
       /* for (Thread thread: threads) {
            thread.start();
        }*/



    }
}