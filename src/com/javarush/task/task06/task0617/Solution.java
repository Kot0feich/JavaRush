package com.javarush.task.task06.task0617;

/**
 * Created by korobovav on 19.06.2017.
 */
public class Solution {
    public static void main(String[] args) {
        printIdea(new Idea());
    }

    //напишите тут ваш код
    public static class Idea {
        public String getDescription() {
            return ("bla bla bla");
        }
    }

    public static void printIdea(Idea idea) {
        System.out.println(idea.getDescription());
    }

}
