package com.revature;

//Person is in a different package than Launcher. So we need to IMPORT it before it's visible to Launcher
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

        

    }

}
