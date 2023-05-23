package com.revature;

public class Launcher {

    //shortcut for making main method: type main, wait for popup, hit enter or tab
    public static void main(String[] args) {

        //int is the most common integer-type primtive (others are byte, short, long)
        int i = 500_000; //good manners to put an underscore where a comma would go

        //if you ever need a REALLY big number, you can use a long
        long l = 1_000_000_000_000_000_000L;

        //we can chain mathematical operations
        System.out.println(5 + 15 * 10 / 5);

        //we can use + to concatenate (attach) variables to a String (or Strings to each other)
        System.out.println("My favorite number is: " + 52);

        //booleans are how we convey true/false. It is the ONLY way to have true/false in java
        boolean bool = true;
        boolean bool2 = false;

        System.out.println(bool);
        System.out.println(bool2);

        //what will this print out?
        System.out.println(3 == 5); //false

        //if else statements check for true/false to determine what they are going to do
        if(bool){
            System.out.println("My boolean is true");
        } else {
            System.out.println("My boolean is false");
        }

    }

}
