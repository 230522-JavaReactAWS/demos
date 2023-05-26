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

        System.out.println(pokemonList);

    }

}
