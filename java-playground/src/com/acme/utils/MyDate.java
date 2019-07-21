package com.acme.utils;
public class MyDate{
    // Member/instance variables (a.k.a.

    public int day;
    public int month;
    public int year;
    // Constructors:
// 1. Same name as the class
    // 2. No return type
    //The no-args constructor
    public MyDate(){
    }
    //Constructor that takes 3 arguments
    public MyDate(int m, int d, int y){
        setDate(m, d, y);
    }
    //Methods
    public String toString(){
        return month + "/" + day + "/" + year;
    }

    public String temp(int a, int b){
        return "";
    }
    public String temp(int a, Integer b){
        return "";
    }
    public String temp(Integer a, Integer b){
        return "";
    }

    public String temp(float a, float b){
        return "";
    }



    public void setDate(int m, int d, int y){
        day = d;
        year = y;
        month = m;
    }
}