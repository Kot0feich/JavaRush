package com.javarush.task.task16.task1617;

/*
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 3;


    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }
        public long startTime;
        public void run() {
            //add your code here - добавь код тут
            try {
                    while (countSeconds>0) {
                        startTime = System.currentTimeMillis();
                        System.out.print(countSeconds+" ");
                        Thread.sleep(1000);
                        countSeconds--;
                    }
                System.out.println("Марш!");
                }
                catch (InterruptedException e ) {
                    if ((System.currentTimeMillis() - startTime)>=3.5) System.out.println("Прервано!");
                }

        }
    }
}
