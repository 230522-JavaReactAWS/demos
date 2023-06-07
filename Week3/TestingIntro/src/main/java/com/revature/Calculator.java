package com.revature;

public class Calculator {

    /* Method ideas
    add
    subtract
    multiply
    divide
     */

    public int add(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

    // Starting with "blank" method that will return 0
    public double divide(double a, double b) throws ArithmeticException{
        // This refused to throw arithmetic exception when I wanted one, we'll fix that right now

        if (b == 0){
            throw new ArithmeticException("You tried to divide by zero dude, that's illegal");
        }

        return a / b;
    }



}
