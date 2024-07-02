package com.revature;

public class Launcher {

    public static void main(String[] args) {

        //Using the built-in Math Class to get a random number
        int randomNum = (int)(Math.random() * 100);

        /*
        what is (int) doing? Math.random() returns a double, we want an int
        We then multiply it by 100, because Math.random() returns a value between 0-1 */

        System.out.println(randomNum);

        System.out.println("==============================(If/Else)");

        //if the (expression) is true, run the code in the {block}. otherwise move on.
        
        if(randomNum > 75){
            System.out.println("Random Number is large");
        } else if (randomNum > 30){
            System.out.println("Random Number is midsized");
        } else {
            System.out.println("Random Number is smol");
        }

        System.out.println("========================(While/Do-While Loops");

        //still using randomNum from above

        //while loop---/

        //WHILE (expression) is true, run the {block}. repeat until the (expression) is false
        while(randomNum < 200){
            randomNum += 20; //increasing randomNum by 20.
            //+=? it's basically shorthand for randomNum = randomNum + 20;

            System.out.println("RandomNum has increased to: " + randomNum);
        }

        System.out.println("While Loop has broken!");

        //Do-While Loop---/

        //Execute the {block} ONCE, and then check the (condition). repeat until false.
        //This is a way to make sure your loop code runs at least once
        do{
            randomNum -= 20;
            System.out.println("RandomNum has decreased to: " + randomNum);
        } while (randomNum > 100);

        System.out.println("Do-While Loop has broken!");

        System.out.println("==============================(For Loops)");

        //basic for loop--/

        //"for as long as this int i, which starts at 0, is less than 10, increment it once per loop"
        //so in essence, we've written a loop that will run some code 10 times.
        for(int i = 0; i < 10; i++){
            //every time this loops, this code will run
            System.out.println("Our loop variable is: " + i);
        }

        //more common use case of for loops: moving through a sequence of values--/

        //This is an Array of Strings. In other words, a String Array.
        String[] birds = {"duck", "duck", "puffin", "duck", "goose", "duck"};

        //Arrays are INDEXED, so we can retrieve individual values using their index
        System.out.println(birds[0]); //Arrays are ZERO INDEXED. The first value is at index zero.
        System.out.println(birds[5]); //Last value. NOT 6, despite there being 6 values. (it goes 0-5)
        System.out.println("----");

        //I'm going to use a for loop to iterate through the Array, and print out ducks
        //I only want to print out ducks, and I want to break my loop entirely if I hit goose

        //"As long as i is less than the number of values in the myName Array, run this block and increment"
        for(int i = 0; i < birds.length; i++){
            
            if(birds[i].equals("puffin")){
                continue; //continue causes the loop to skip its current iteration (its current loop)
            }

            if(birds[i].equals("goose")){
                break; //break causes the loop to break entirely
            }    

            //if neither of the if statements run, print out the String (should only be ducks)
            System.out.println(birds[i]);

        }

        //quick example of using &&
        //"If the first expression AND the second expression are true, return true"
        if(5 == 5 && 10 == 10){
            System.out.println("the numbers are equal!");
        }

        System.out.println("=========================(Switch Statements)");

        //Switches take in a value, and perform one of many options depending on the value

        System.out.println("What is the best Pokemon?");

        String pokemon = "Totodile";

        //"cases" check the inputted value
        //if the value matches one of the cases, then that case's code will run
        switch(pokemon){
            case "Mudkip": {
                System.out.println("Correct!");
                break;
            }
            case "Totodile": {
                System.out.println("Close, but not the best one");
                break;
            }
            case "Diglett": {
                System.out.println("Your opinion is wrong");
                break; //without a break statement, every single case will run after one matches
                //we need breaks to "break" out of the switch
            }
            default: { //the default block will run if none of the above cases are matched
                System.out.println("Your choice was so bad that it was not recognized.");
            }
        }

    }

}
