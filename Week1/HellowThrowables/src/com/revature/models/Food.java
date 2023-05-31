package com.revature.models;

public class Food {

    public String name;
    public boolean isCookie; //is this food a cookie or not?

    //right click -> generate -> constructor -> Select all of them -> OK
    public Food(String name, boolean isCookie) {
        this.name = name;
        this.isCookie = isCookie;
    }

}