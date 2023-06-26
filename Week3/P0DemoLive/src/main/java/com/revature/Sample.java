package com.revature;

public class Sample {

    public static void main(String[] args) {

        Function f = ((x, y) -> {
            if (x > y){
                return x;
            }
            return y;
        });


        System.out.println(f.test(3,67));
    }
}
