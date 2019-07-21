package com.company;

public class Person {
    {
        personCount = 10;
    }
    static {
        personCount = 20;
    }


    {
        personCount = 30;
    }
    static {
        personCount = 40;
    }

    public static int personCount = 1000;


    private int data;
    Person(int data){
        this.data =data;
    }

    Person(){}

}
