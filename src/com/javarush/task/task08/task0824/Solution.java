package com.javarush.task.task08.task0824;

import java.util.ArrayList;

/**
 * Created by korobovav on 12.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human("Masha",false,10);
        Human child2 = new Human("Andrey",true,11);
        Human child3 = new Human("Yullia",false,12);

        ArrayList<Human> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        children.add(child3);

        Human papa1 = new Human("Andrey",true, 39, children);
        Human mama1 = new Human("Olia", false,41,children);

        ArrayList<Human> children1 = new ArrayList<>();
        children1.add(papa1);
        ArrayList<Human> children2 = new ArrayList<>();
        children2.add(mama1);

        Human grandpa1 = new Human("Vova",true,62,children1);
        Human grandma1 = new Human ("Tania",false,62, children1);

        Human grandpa2 = new Human("Kolia",true,65,children2);
        Human grandma2 = new Human ("Liuba",false, 65, children2);

        System.out.println(grandpa1.toString());
        System.out.println(grandma1.toString());
        System.out.println(grandpa2.toString());
        System.out.println(grandma2.toString());
        System.out.println(papa1.toString());
        System.out.println(mama1.toString());

        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        Boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human (String name, boolean sex, int age) {
            this.name = name;
            this.sex=sex;
            this.age=age;
        }

        public Human (String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex=sex;
            this.age=age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
