package com.company;

import com.acme.domain.Order;
import com.acme.utils.ConversionService;
import com.acme.utils.MyDate;
import com.acme.utils.Testing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {


    private static void temp(){
        System.out.println(ConversionService.fluidOunces(1.1f));
        System.out.println(ConversionService.gallons(2.2f));
        System.out.println(ConversionService.grams(30));
        System.out.println(ConversionService.milliliters(40));
        System.out.println(ConversionService.ounces(50));
        System.out.println(ConversionService.pints(6.6f));
        System.out.println(ConversionService.pounds(7.7));
// can you figure out why these do not compile
        ConversionService.fluidOunces((float)1.1);
        ConversionService.grams((int)30L);
        ConversionService.milliliters((int)4.0);
        short grams = (short)ConversionService.grams(30);
        byte byteGrams = (byte)ConversionService.grams(30);
// why do these still work even though the types are

        System.out.println("------------------------------------ ");
        double ounces = ConversionService.fluidOunces(1.1f);
        System.out.println(ounces);
        long milliliters = ConversionService.milliliters(40);
        System.out.println(milliliters);
        double decimalMilliliters =
                ConversionService.milliliters(40);
        System.out.println(decimalMilliliters);
        short s = 30;
        System.out.println(ConversionService.grams(s));
        byte b = 4;
        System.out.println(ConversionService.milliliters(b));
        char z = 'z';
        System.out.println(ConversionService.milliliters(z));
        System.out.println(ConversionService.gallons(200));
        System.out.println(ConversionService.ounces(50.5f));
        System.out.println(ConversionService.pints(6L));
        System.out.println(ConversionService.pounds(7L));
// compare these results. Can you tell why they are

        System.out.println("------------------------------------ ");
        float bigGallons =
                ConversionService.gallons(123456789123456789L);
        System.out.println(bigGallons);
        double bigGallons2 = 123456789123456789L * 0.2642;
        System.out.println(bigGallons2);
        System.out.println("------------------------------------");
        int bigGrams = ConversionService.grams(1234567890);
        System.out.println(bigGrams);
        long bigGrams2 = 1234567890L * 1000L;
        System.out.println(bigGrams2);



    }
    private static Integer sample(Integer i){

        return new Integer(null);
        //return i == null ? i: 0;

        /*if(i == null){
            return i;
        }
        return 0;*/

    }

    public static void passObject(MyDate d) {
        d.year = 2009;
    }
    public static void passPrimitive(int i) {
        i = 2010;
    }
    public static void passString(String s) {
        int yearSlash = s.lastIndexOf('/');
        s = s.substring(0, yearSlash + 1);
        s += "2012";
        System.out.println("New date string: " + s);
    }


    public static void main(String[] args) {

        Sample2 s = new Fuu();
        String g = s.getDate();

        HashMap<String,MyDate> m1 = new HashMap<>();
        m1.put("G1", new MyDate());
        HashSet<String> mySet= new HashSet<String>();

        Testing blah = new Testing();
        //blah.f = 6;

        MyDate date = new MyDate(1, 20, 2008);
        System.out.println("Before passing an object " + date);
        passObject(date);
        System.out.println("After passing an object " + date);
        System.out.println("Before passing a primitive " +
                date.year);
        passPrimitive(date.year);
        System.out.println("After passing a primitive " +
                date.year);
        String x = date.toString();
        System.out.println("Before passing a String " + x);
        passString(x);
        System.out.println("After passing a String " + x);



        char t6 = 'A';
        String s1 = "testString";
        String s2 = "testString";

        Car car = new Car();
        StringBuffer stringBuffer = new StringBuffer("Init");
        car.tricky(stringBuffer);
        System.out.println(stringBuffer.toString());

        try {
            Integer a = null;
            Integer t = sample(null);
        }
        catch (Exception ex){
            System.out.println(ex.fillInStackTrace());
        }

        if(s1 == s2) System.out.println("equals!");

        String h =  Character.toString(t6);

        temp();
        Integer d2 = 4;
        d2 = 7;
        Map<String,Integer> m = new HashMap<>();
        m.put("g",5);
        Integer t = m.get("g");
        t++;
        m.put("g",t);


        System.out.println(Person.personCount);
        Person p = new Person();
        System.out.println(Person.personCount);
        Person.personCount = 100;
        p = new Person();
        System.out.println(Person.personCount);

	// write your code here
        MyDate date4 = new MyDate();
        System.out.println(date4.toString());
       // date4.calculate(null);
        MyDate date1 = new MyDate(11,11,1918);

        Integer d ;
        d = null;

        MyDate date2 = new MyDate();
        date2.day = 11;
        date2.month = 11;
        date2.year = 1918;

        MyDate date3 = new MyDate();
        date3.setDate(4,21,1968);

        String str1 = date1.toString();
        String str2 = date2.toString();
        String str3 = date3.toString();

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);


        MyDate date7 = new MyDate(1,20,2008);
        Order anvil = new Order(date1, 2000.00, "Wile E Coyote",
                "Anvil",
                10);

        MyDate date8 = new MyDate(4,10,2008);
        Order balloons = new Order(date2, 1000.00, "Bugs Bunny",
                "Balloon", 125);

        System.out.println(anvil);
        System.out.println(balloons);

        System.out.println("The tax Rate is currently: " +
                Order.taxRate);
        Order.computeTaxOn(3000.00);
        anvil.computeTax();
        balloons.computeTax();

        Order.setTaxRate(0.06);
        System.out.println("The tax Rate is currently: " +
                Order.taxRate);
        Order.computeTaxOn(3000.00);
        anvil.computeTax();
        balloons.computeTax();


    }
}
