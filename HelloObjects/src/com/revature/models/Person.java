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

}
