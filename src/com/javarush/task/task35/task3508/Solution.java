package com.javarush.task.task35.task3508;

import java.util.List;

/*
extends vs super
1) one - должен работать с одним и тем же типом;
2) two - должен добавлять любых наследников типа T в список, умеющий хранить только тип T;
3) three - должен добавлять объекты типа T в любой список, параметризированный любым родительским классом;
4) four - должен добавлять любых наследников типа T в список, параметризированный любым родительским классом.
*/
public abstract class Solution {
    public abstract <T> void one(List<T> destination, List<T> source);

    public abstract <T> void two(List<T> destination, List<? extends T> source);

    public abstract <T> void three(List <? extends T> destination, List<T> source);

    public abstract <T> void four(List <? extends T> destination, List <? extends T> source);
}
