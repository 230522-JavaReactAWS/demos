package com.revature.exceptions;

public class TeacherNotFoundException extends RuntimeException{

    public TeacherNotFoundException(String message){
        super(message);
    }
}
