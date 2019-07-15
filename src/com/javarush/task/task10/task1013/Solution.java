package com.javarush.task.task10.task1013;


/*
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private int age=0;
        private String firstName=null;
        private String middleName=null;
        private String lastName=null;
        private boolean sex=true;
        private int weight=0;
        public Human (String firstName) {
            this.firstName = firstName;
        }
        public Human (int age) {
            this.age = age;
        }
        public Human(boolean sex) {
            this.sex = sex;
        }
        public Human (String firstName, String middleName) {
            this.firstName=firstName;
            this.middleName=middleName;
        }
        public Human (String firstName, String middleName, String lastName) {
            this.firstName=firstName;
            this.middleName=middleName;
            this.lastName=lastName;
        }
        public Human (String firstName, String middleName, String lastName, boolean sex) {
            this.firstName=firstName;
            this.middleName=middleName;
            this.lastName=lastName;
            this.sex=sex;
        }
        public Human (String firstName, String middleName, String lastName, boolean sex, int age) {
            this.firstName=firstName;
            this.middleName=middleName;
            this.lastName=lastName;
            this.sex=sex;
            this.age=age;
        }
        public Human (String firstName, String middleName, String lastName, boolean sex, int age, int weight) {
            this.firstName=firstName;
            this.middleName=middleName;
            this.lastName=lastName;
            this.sex=sex;
            this.age=age;
            this.weight=weight;
        }

        public Human (String firstName, String lastName, boolean sex, int age) {
            this.firstName=firstName;
            this.lastName=lastName;
            this.sex=sex;
            this.age=age;
        }
        public Human (String firstName, String lastName, boolean sex, int age, int weight) {
            this.firstName=firstName;
            this.lastName=lastName;
            this.sex=sex;
            this.age=age;
            this.weight=weight;
        }
    }
}

