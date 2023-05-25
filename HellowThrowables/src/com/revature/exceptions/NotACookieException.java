package com.revature.exceptions;

/* This Class extends Exception. This makes it a Checked Exception (aka compile time Exception)
   So now, this Class has all the basic functionalities of any other Exception (can crash code etc.)
   If we wanted an UNCHECKED Exception, we would extend RuntimeException instead */

public class NotACookieException extends Exception{

    //The whole point of this constructor is to return a String telling the user what went wrong
    //This message is known as a STACK TRACE.
    public NotACookieException(String message) {
        super(message); //remember, super() calls the parent constructor
    }
}
