package com.revature;

import com.revature.models.Animal;
import com.revature.models.Cat;
import com.revature.models.Lion;

public class Launcher {

    public static void main(String[] args) {

        Lion l = new Lion(4);

        //call some methods
        l.move(); //from Interface
        l.makeNoise(); //from Abstract Class (had to override)
        l.sneeze(); //from Abstract Class (was already defined. didn't need to override)

        //call some variables
        System.out.println(l.whiskers); //from the Abstract Class
        System.out.println(l.isOrganic); //from the Interface


        /* Cat is an abstract Class, Animal is an Interface. Neither can be instantiated
        In other words we can't make objects out of them

         Cat c = new Cat();
         Animal a = new Animal();
        */

    }

}
