package com.revature;

//Person is in a different package than Launcher. So we need to IMPORT it before it's visible to Launcher
import com.revature.models.Associate;
import com.revature.models.Person;

public class Launcher {

    public static void main(String[] args){

        //Instantiate (create) a Person object with the no-args constructor
        //This will let us access its variables and use its methods
        Person p = new Person();

        p.walk(); //this returns a String... but does nothing with it

        //In order to actually SEE the String in our console, we will need to print it out
        System.out.println(p.walk());

        //let's print out some Person variables
        System.out.println(p.name + " is " + p.age + " years old.");

        //Instantiating 2 new Person objects with the all-args constructor
        Person p2 = new Person("John", 44, 8);
        Person p3 = new Person("Pitbull", 42, 6);

        //let's see some variables of these Person objects.
        System.out.println(p2.name + " and " + p3.name + " are writing club bangers");

        //Using Associate and its members--------------

        Associate a = new Associate(); //no args associate

        a.code(); //code() has a print statement inside of it already
        System.out.println(a.walk()); //walk() returns a String, which we then have to print out

        //These two values are coming from the Person Class (inherited by Associate)
        System.out.println(a.age);
        System.out.println(a.name);

        //all-args Associate
        Associate a2 = new Associate("Ben", 25, 9, true);


        //recall that the code() method is specific to the Associate Class
        //p3.code(); //THIS WON'T WORK! code() was declared in Associate, not Person

    }

}
