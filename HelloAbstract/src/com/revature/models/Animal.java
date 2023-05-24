package com.revature.models;

/* This is an INTERFACE, which can contain variables and ABSTRACT methods
Interfaces are meant to be IMPLEMENTED by Classes, which give functionality to the abstract methods
 The reason Interfaces are called "contracts" is because any implementing Class MUST implement the methods.
 */
public interface Animal {

    //Interface variables are public, static, final by default.
    boolean isOrganic = true; //remember, final variables can't be changed so let's leave this true.

    //Abstract Method - no method body! public abstract by default
    void move();

    /* every Animal should be able to move. However, not every animal will move the same way
    the job of an Interface is to lay out IDEAS of behaviors, but not how to perform those ideas
    "how to perform" is the job of any Class that is implementing the method. */

}
