package com.revature;

import com.revature.models.Pokemon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

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

        //Instantiate an empty HashSet (which imo is a general-use Set)
        HashSet<Pokemon> pokemonSet = new HashSet();

        pokemonSet.add(new Pokemon("Mudkip", "Water"));
        pokemonSet.add(new Pokemon("Arbok", "Poison"));
        pokemonSet.add(new Pokemon("Bulbasaur", "Grass/Poison"));
        //Sets are unordered! The order of insertion does not influence the order of the Set (unlike Lists)

        //Sets don't allow duplicates.

        //this is legal, because of the "new" keyword. It's a new object in memory
        pokemonSet.add(new Pokemon("Bulbasaur", "Grass/Poison"));

        //Let's add the same object twice to demonstrate this
        Pokemon magikarp = new Pokemon("Magikarp", "Water");

        pokemonSet.add(magikarp);
        pokemonSet.add(magikarp);

        System.out.println(pokemonSet);

        //A new bulbasaur object that we'll use below
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "Grass/Poison");

        //an enhanced for loop to compare each Pokemon object in the HashSet with the bulbasaur above
        //"For every Pokemon object, which we'll call "p", in the pokemonSet, check if it is equal to our bulbasaur
        for(Pokemon p : pokemonSet){
            System.out.println(bulbasaur.equals(p));
            //bulbasur.equals(bulbasaur) == true, so we get true when we hit a bulbasaur
        }

        //contains() returns true if a Set contains a certain object
        System.out.println(pokemonSet.contains(bulbasaur));

        System.out.println("==============================(Queues)");

        //LinkedList implements List AND Queue
        LinkedList<Pokemon> pokemonLL = new LinkedList();

        pokemonLL.add(new Pokemon("Mudkip", "Water"));
        pokemonLL.add(new Pokemon("Arbok", "Poison"));
        pokemonLL.add(new Pokemon("Bulbasaur", "Grass/Poison"));

        System.out.println(pokemonLL); //ordered!

        System.out.println(pokemonLL.peek()); //peek() gets the first value

        System.out.println(pokemonLL.poll()); //poll() gets and removes the first value

        System.out.println(pokemonLL); //first value of the LinkedList is gone!!

        pokemonLL.remove(1); //what?? I thought you could only access the first element in a Queue

        //true, but remember, LinkedLists also implement List. So they inherit from Queue AND List

        System.out.println(pokemonLL);

        

    }

}