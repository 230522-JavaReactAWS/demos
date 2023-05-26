package com.revature;

import com.revature.models.Pokemon;

import java.util.ArrayList;

public class Launcher {

    public static void main(String[] args) {

        System.out.println("=========================(Lists)");

        //ArrayLists are very common implementations of the List Interface
        //QC once asked me the difference between ArrayLists and Arrays

        //An ArrayList of Pokemon objects
        ArrayList<Pokemon> pokemonList = new ArrayList();

        //add some pokemon to my ArrayList with the .add() method
        //I'm going to instantiate the new Pokemon objects directly in the .add() method
        pokemonList.add(new Pokemon("Mew", "Psychic"));
        pokemonList.add(new Pokemon("Feraligator", "Water"));
        pokemonList.add(new Pokemon("Charizard", "Fire/Flying"));
        pokemonList.add(new Pokemon("Garbodor", "Poison"));
        pokemonList.add(new Pokemon("Jigglypuff", "Normal/Fairy"));
        pokemonList.add(new Pokemon("Jigglypuff", "Normal/Fairy")); //Lists can have duplicates

        System.out.println(pokemonList);

        //this returns an int representing the number of values
        //similar to the length property of Arrays
        System.out.println("Pokemon in party: " + pokemonList.size());

        //.get() will get you the element at a specified index
        System.out.println("The 4th pokemon in my party is: " + pokemonList.get(3));

        //set will allow you to change the value found at a certain index
        pokemonList.set(5, new Pokemon("Mewtwo", "Psychic"));

        //now, one of the Jigglypuffs is gone
        System.out.println(pokemonList);

        //we can use .forEach() method to do something for every Pokemon in the ArrayList
        pokemonList.forEach(pokemon -> System.out.println("Hello from: " + pokemon.getName()));

        /* forEach explanation -

            "FOR EACH OBJECT in the Collection, do something."
            What is the arrow? ->? this is called a lambda
            Basically, you provide a value (or more), and use that value in some expression
            In this case, we're providing a Pokemon object and printing out its name

            note the variable name "pokemon". This name could be anything since it's just a variable name
         */

        //this time, we'll use the forEach to call the fight() method for each pokemon object
        pokemonList.forEach(pokemon -> pokemon.fight());

        //Mew got smoked in the fight. So we need to remove it from the ArrayList with .remove()
        pokemonList.remove(0);

        System.out.println("Remaining Pokemon: " + pokemonList);

        System.out.println("=============================(Sets)");

        

    }

}