package com.revature.models;

public class Pokemon {

    //These variables will be private for the sake of ENCAPSULATION (One of the 4 pillars of OOP)
    private String name;
    private String type;

    //one method just for spice
    public void fight(){
        System.out.println(name + " is attacking!");
    }

    //BOILERPLATE CODE--------------------------------/

    //constructors, getters/setters, toString, hashCode/equals

    //Remember, constructors let us INSTANTIATE an object by INITIALIZING their variables
    //they let us make objects by giving values to their variables

    //no-args constructor: right click -> generate -> constructor  -> select none
    public Pokemon() {
    }

    //all-args constructor: right click -> generate -> constructor  -> shift + click the last variable -> select
    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    //The toString method lets us print out objects as String representations (INSTEAD OF MEMORY ADDRESS)

    //right click -> generate -> toString() -> ok
    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
