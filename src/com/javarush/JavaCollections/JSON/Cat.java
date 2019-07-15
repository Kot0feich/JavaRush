package com.javarush.JavaCollections.JSON;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
class Cat
{
    public String name;
    public int age;
    public int weight;
    Cat(){}
}