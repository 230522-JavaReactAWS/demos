package com.revature;

public class Launcher {

    public static void main(String[] args) {

        System.out.println("==========================(String Immutability)");

        //Strings are immutable, so we can't change them

        String s = "I am immutable (AKA unchangeable)";

        s.toLowerCase(); //toLowerCase() turns a String into all lowercase
        //This operation IS actually happening, but it's not getting saved/printed anywhere

        //Again, Strings can't change, so the original String is unchanged
        System.out.println(s);

        //in this case, we get the String in all lowercase. We're printing out the return value
        System.out.println(s.toLowerCase());

        //we could also save this returned value into a new String
        String s2 = s.toLowerCase();

        System.out.println("New String s2: " + s2);
        System.out.println("Old String s: " + s);

        System.out.println("================================(String Equality)");

        //we can check for primitive equality using ==
        int i = 5;
        System.out.println(i == 5);

        //for Strings, and any other object, we must use the .equals() method
        String st = "Hi Java"; //This is a String literal (no "new" keyword)
        String st2 = "Hi Java"; //This is another String literal with the same value as above

        //the two Strings above are actually the same object because they are String literals

        //since we used the "new" keyword, this will be a brand new object in Java memory
        String st3 = new String("Hi Java");

        //this is another brand new object
        String st4 = new String("Hi Java");

        //false == compares memory address, and these are separate objects
        System.out.println(st2 == st3);

        //true == compares memory address, but st and st2 are the same object
        System.out.println(st == st2);

        //false again, these are two different objects and we're using ==
        System.out.println(st3 == st4);

        //see why == is not ideal for objects? despite equal values, they are not considered equal

        //THIS is exactly why we use .equals() for any object
        System.out.println(st.equals(st4)); //true. different objects, but same value

        System.out.println(st3.equals(st4)); //true, same as above

        System.out.println("============================(String Methods)");

        //A pangram to use some String methods on
        String pangram = "Sphinx of Black Quartz, judge my vow";

        //.length() returns an int representing the length of the String
        System.out.println(pangram.length());

        //.subString() returns a String found within the original String
        System.out.println(pangram.substring(10));
        System.out.println(pangram.substring(10, 30));

        //.split() will create an Array via certain delimiters (things to separate by)
        System.out.println(pangram.split(" "));
        //This gives a bunch of what seems like nonsense. That nonsense is a MEMORY ADDRESS
        //We can't usually print out objects. Strings do it "automatically"

        //We can make a new String array, and then loop through it!
        String[] words = pangram.split(" ");

        //This is an "enhanced for loop", it's like a shortcut for loop.
        //We'll use it to iterate (move) through the Array
        for(String word : words){ //"For every String in the Array called words... Do something"
            System.out.println(word);
        }

        //.charAt() that returns the char at a given index (place)
        System.out.println(pangram.charAt(1)); //p
        System.out.println(pangram.charAt(0)); //S

        //a small method chain - "give me the character at length - 1"
        //we need length - 1 because Strings are zero indexed, so the last index is 35 (not 36)
        System.out.println(pangram.charAt(pangram.length() - 1)); //w

        //Strings (and every other Array) are ZERO INDEXED
        //this means the first character is going to be at index 0 (not 1)

    }

}