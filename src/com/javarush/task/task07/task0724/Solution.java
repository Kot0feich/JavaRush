package com.javarush.task.task07.task0724;

/**
 * Created by korobovav on 28.06.2017.
 */
public class Solution {
    public static void main(String[] args) {
        Human grandFatherHusband = new Human("Volodia", true, 57);
        Human grandMotherHusband = new Human("Tatiana", false, 57);
        Human grandFatherWife= new Human("Nikolay", true, 59);
        Human grandMotherWife = new Human("Lyuba", false, 59);
        Human father = new Human("Andrey", true, 39,grandFatherHusband,grandMotherHusband);
        Human mother = new Human("Olia", false, 18 ,grandFatherWife, grandMotherWife);
        Human son = new Human("Sereja", true, 12, father, mother);
        Human son1 = new Human("Gleb", true, 12, father, mother);
        Human daughter = new Human("Nona", false, 12, father, mother);


        System.out.println(grandFatherHusband.toString());
        System.out.println(grandMotherHusband.toString());
        System.out.println(grandFatherWife.toString());
        System.out.println(grandMotherWife.toString());
        System.out.println(father.toString().toString());
        System.out.println(mother.toString().toString());
        System.out.println(son.toString());
        System.out.println(son1.toString());
        System.out.println(daughter.toString());
    }
    public static class Human {
        //напишите тут ваш код
        String name;
        Human father;
        Human mother;
        boolean sex;
        int age;

        public Human (String name, boolean sex, int age) {
            this.name=name;
            this.sex=sex;
            this.age=age;
        }
        public Human (String name, boolean sex, int age, Human father, Human mother) {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.father=father;
            this.mother=mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}
