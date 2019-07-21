package com.company;


import java.util.HashMap;

interface Sample{
    default String getDate(){
        return "Sample2";
    }
}
interface Sample2 {
    default String getDate(){
        return "Sample2";
    }
}

class Fuu implements Sample,Sample2{


    public String getDate() {
        return null;
    }
}

class Father{
    /**
     * Sole constructor.  Programmers cannot invoke this constructor.
     * It is for use by code emitted by the compiler in response to
     * enum type declarations.
     *
     * @param name    - The name of this enum constant, which is the identifier
     *                used to declare it.
     * @param ordinal - The ordinal of this enumeration constant (its position
     *                in the enum declaration, where the initial constant is assigned
     */


    public  void drive(){}
}
class Son extends Father{
   public String title;
    public final void drive(){


    }
}

public class Car {
    private final String temp;

    Car(){
        temp = "data";
        //Son p = new Father();
        //p.title = "dsds";
    }
    Car(String d){
        temp = d;
    }
    void tricky(StringBuffer b){
            b.append("ddd");
    }

}
