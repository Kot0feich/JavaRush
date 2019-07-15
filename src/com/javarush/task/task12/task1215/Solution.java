package com.javarush.task.task12.task1215;

/*
Кошки не должны быть абстрактными!
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat {
        public String getName () {
            return "Name";
        }
        public Cat getChild () {
            Cat pet = new Cat();
            return pet;
        }

    }

    public static class Dog {
        public String getName () {
            return "DogName";
        }
        public Dog getChild () {
            Dog dog = new Dog();
            return dog;
        }

    }

}