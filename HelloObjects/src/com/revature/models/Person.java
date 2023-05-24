package com.revature.models;

//This is a Class meant to MODEL a Person - think of it as a blueprint (or model) for all Person Objects
//This Class defines all the attributes (variables/fields) and behaviors (methods) of a Person
public class Person {

    //Declare some Person variables - every Person will have these attributes
    public String name;
    public int age;
    public double height;

    //Declare a method for the Person Class. Something a person can do.
    public String walk(){
        return "Ayeeee I'm walking here";
    }

    /* Method Disambiguation

    This walk() method is public, so it's visible everything in the application
    It has a return type of String. so, it must return a String (note the return statement)
    It takes no (parameters), so we don't need to supply any arguments when calling this method.
     */

    //constructors below--------------------

    /* Remember, constructors are methods that allow us to give values to our object's variables

     When we instantiate an object, we use a constructor depending on what values we want
     Constructors will have the same name as the Class, but no return type. */

    /* These Constructors are examples of METHOD OVERLOADING
        Overloaded methods have the SAME NAMES, but DIFFERENT PARAMETERS
            By different I mean different number, or order of the data types
            (The return type can be different too)

        This is an example of POLYMORHPISM (a pillar of OOP)
            "Same name/thing different forms"
     */

    //no-args constructor. It takes NO ARGUMENTS. Typically used to give default values to an object
    //If you create a Person object with no parameters, this constructor will get used
    public Person(){
        this.name = "Daryn"; //String
        this.age = 29; //int
        this.height = 7.5; //double
        //what is "this"? It's referring to the variable of THIS Class
        //THIS Class's name variable. THIS Class's age variable. etc.
    }
    //no-args constructors are like the default state for an object that we don't customize
    //AKA objects we give me initial values to.

    //all-args constructor. This constructor takes a parameter (argument) for each Person variable
    //This lets us make Person objects with whatever values we choose
    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    /*we saw a no-args and an all-args constructor
    We can ALSO make SOME-ARGS constructors.
    maybe we want some default values and some user-inputted values */
    public Person(int age, double height){
        this.name = "Mike Tyson";
        this.age = age;
        this.height = height;
    }
    //with this, we would have a default name, and a user-inputted age and height

}
