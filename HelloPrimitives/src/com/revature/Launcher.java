package com.revature;

public class Launcher {

    //shortcut for making main method: type "main", wait for popup, hit enter or tab
    public static void main(String[] args) {

        //int is the most common integer-type primtive (others are byte, short, long)
        int i = 500_000; //good manners to put an underscore where a comma would go

        //if you ever need a REALLY big number, you can use a long
        long l = 1_000_000_000_000_000_000L;

        //we can chain mathematical operations
        //rememeber "sout" is the shortcut to make a print statement
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

        //chars are written with 'single quotes', unless they're numbers
        char c = 'c';

        char c2 = 15000; //What?? I thought chars were single CHARacters
        //true, but numbers in a char are UNICODE VALUES
        System.out.println(c2);

        //doubles are the most common floating-point number (they have decimal places)
        double d = 2.0945;

        //what happens if we add an int and a double?
        System.out.println(5 + d); //the int get added to the double, and a double is returned

        //floats take up half as much memory than doubles, but are less commonly used
        float f = 5.75F; //and you must include an "f" at the end of the value

        System.out.println("================================(Arithmetic Operators)");

        /*
        we know how +, -, *, / work

        the modulus (%) returns the REMAINDER of a division
         */

        int testNum1 = 10;
        int testNum2 = 11;

        //"If the remainder of 10/2 is 0..."
        if(testNum1 % 2 == 0){
            System.out.println("The number is even");
        }

        //"If the remainder of 11/2 is 0..."
        if(testNum2 % 2 == 0){
            //of course, 11/2 has a remainder. so this will not print.
            System.out.println("The number is even");
        } else {
            System.out.println("The remainder is: " + testNum2 % 2);
        }

        //INCREMENTS/DECREMENTS

        //we use ++ to increase a number by 1 (increment)
        //we use -- to decrease a number by 1 (decrement)
        //very useful in loops or any kind of counter

        int funnyNumber = 24;
        System.out.println("funnyNumber is: " + funnyNumber);

        funnyNumber++; //This will increase the value by 1
        System.out.println("What's funnier than 24? " + funnyNumber);

        funnyNumber--; //This will decrease the value by 1
        System.out.println("funnyNumber is now less funny: " + funnyNumber);

        //pre vs post increment?

        int k = 5;

        //what's the difference between ++k and k++?
        //they both increment k, but WHEN the increment happens is different

        System.out.println(k++); //this will print out 5...
        System.out.println(k); //AND THEN this will print 6

        //this is where pre increments come in handy... when you need the new value right away
        System.out.println(++k);

        /* RULE OF THUMB:

            pre-increment increments FIRST, and then does whatever expressions it's tasked with
            post-increment increments AFTER whatever expression it's tasked it

         */

    }

}
