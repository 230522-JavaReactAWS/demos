package com.revature.models;

import java.util.Objects;

//we don't have to explicitly type out "extends Object". Every Class implicitly extends Object
public class Pokemon extends Object{

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

    //The toString() method lets us print out objects as String representations (INSTEAD OF MEMORY ADDRESSES)
    //right click -> generate -> toString() -> ok
    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    //right click -> generate -> getter and setter -> select every field and hit ok

    /* What are getters and setters?

     Combined with private variables, they are how we achieve ENCAPSULATION
     In a secure application, your Class's variables will typically be private
     In other words, with encapsulation, you cannot ACCESS or CHANGE (get or set) these variables
     UNLESS you use getters and setters.

     You don't want your variables to change or be viewed on accident.
     You want ONE SPECIFIC WAY to view or change those variables. That's where getters and setters come in
     Getters let you access (get) data. Setters let you change (set) data. */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    //right click -> generate -> equals and hashCode -> next through everything -> create

    //these two methods work together to let us compare two objects
    //equals() is the one we use, hashCode() is more of a helper method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(getName(), pokemon.getName()) && Objects.equals(getType(), pokemon.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getType());
    }
}
