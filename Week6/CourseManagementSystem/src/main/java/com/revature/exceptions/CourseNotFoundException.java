package com.revature.exceptions;

// This guy is gonna be an unchecked exception that is thrown when we can't find a course for whatever reason
public class CourseNotFoundException extends RuntimeException{

    // Define a constructor for our custom exception and make it pass the message it receives to its parent class
    public CourseNotFoundException(String message){
        super(message);
    }
}
