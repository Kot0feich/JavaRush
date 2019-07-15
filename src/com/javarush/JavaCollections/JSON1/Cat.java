package com.javarush.JavaCollections.JSON1;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
@JsonAutoDetect
class Cat {

        public String name;
        public int age;
        public int weight;

        Cat() { }

}
