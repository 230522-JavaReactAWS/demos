package com.revature.models;

/* Associate EXTENDS Person. So what?

First of all, this is a primary example of INHERITANCE (one of the pillars of OOP)
This means that the Associate Class has ALL of the members of the Person Class (they were inherited)
BUT, it can also have its own members (variables/methods) unique to Associate
Associate is therefore a CHILD CLASS of Person. In other words, it's a SUBCLASS of Person. */

public class Associate extends Person {

    //Associate has all the variables of Person. Let's make a variable that is unique to Associates
    public boolean isEmployed = true;

    //Let's also make a method that's unique to associates
    public void code(){
        System.out.println("I am coding and having a great time :)");
    }

    /*METHOD OVERRIDING - we're taking the original walk() method from Person, and changing what it does
    This is something only done in Child/Parent Class relationships. Child overrides Parent

    If we had not overridden walk(), then Associate would have the exact same walk() method.
    But here, we declare the SAME METHOD SIGNATURE, but with a DIFFERENT METHOD BODY
    This is an example of POLYMORPHISM (a pillar of OOP)
     */
    @Override
    public String walk(){
        return "I am walking to my desk to continue the grind";
    }

    //Constructors below-------------------(Check the Person Class for descriptions on constructors)

    //no-args constructor
    public Associate() {
        super(); //super calls the parent constructor!
        //We gave super() no args, so it'll call the no args constructor of Person
        //we don't need to give a value for "isEmployed" because we already did that above (line 13)
    }

    //all-args constructor
    public Associate(String name, int age, double height, boolean isEmployed) {
        super(name, age, height); //this time, we're calling the all-args constructor of Person
        this.isEmployed = isEmployed; //and whatever the User enters for isEmployed will be used.
    }

}
