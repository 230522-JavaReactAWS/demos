package com.revature.models;

/* This is an abstract class, note the "abstract" non-access modifier. It implements the Animal Interface
    So now, this abstract class also has access to everything in Animal

    Abstract Classes are Classes with AT LEAST one abstract method
    AND they can have concrete (implemented) methods as well

    Why use an Abstract Class over an Interface?
    -I use Abstract Classes when I KNOW I want to have methods that are already implemented (defined)
    -This will cause any subclasses to share that default functionality.

    -I mostly use Interfaces. Usually, I don't need concrete methods in my abstract entities
    -I don't usually require implemented methods when I'm defining abstract methods.
    -My concrete Classes define them all anyway.

  */

public abstract class Cat implements Animal {

    //A variable that all cats have (we'll give it a value in each subclass)
    public int whiskers;

    //We haven't defined how a Cat should make noise. We can change (override) this per each subclass
    public abstract void makeNoise();

    //All cats sneeze the same, so we can have a concrete (implemented) method for sneeze
    public void sneeze(){
        System.out.println("ka chew :3");
    }

    //we could have @Overridden move() in this abstract class as well,
    //but I decided to do it in the Lion Class

    //constructor---/

    //one all-args constructor
    public Cat(int whiskers) {
        this.whiskers = whiskers;
    }

}
