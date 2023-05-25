package com.revature.models;

/* [more stuff here]

 Lion extends Cat. Cat implements Animal. So Lion automatically has everything from Animal AND Cat
 In other words, Lion has INHERITED every member found in Cat and in Animal
 */
public class Lion extends Cat{

    //Now, this Class is tasked with defining the move method
    @Override
    public void move() {
        System.out.println("Lion is stalking in the grass");
    }

    //notice how we didn't need to override the sneeze() method. It was already implemented
    //we could have overridden it if we wanted to change the functionality

    @Override
    public void makeNoise() {
        System.out.println("ROOOOOOOARRR");
    }

    //move() and makeNoise() were both abstract Classes that this Class was forced to implement
    //move() came from the Interface and makeNoise() came from the Abstract Class


    //some constructors------------

    //remember, constructors let us assign variables to our objects when we instantiate (make) them

    //this all-args constructor calls to the constructor found in Cat
    public Lion(int whiskers) {
        super(whiskers); //remember, super is what calls to the parent constructor
    }

}