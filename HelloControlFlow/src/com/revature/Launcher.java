package com.revature;

public class Launcher {

    public static void main(String[] args) {

        //Using the built-in Math Class to get a random number
        int randomNum = (int)(Math.random() * 100);

        /*
        what is (int) doing? Math.random() returns a double, we want an int
        We then multiply it by 100, because Math.random() returns a value between 0-1 */

        System.out.println(randomNum);

        System.out.println("==============================(If/Else if/Else)");

        if(randomNum > 75){
            System.out.println("Random Number is large");
        } else if (randomNum > 30){
            System.out.println("Random Number is midsized");
        } else {
            System.out.println("Random Number is smol");
        }

        /*
         If the first condition is met, its block will run and the if else ends
         If the first condition is not met, the else if block is tested
         If the else if condition is met, it runs its block and the if else ends
         If no conditions are met, the else block is called
          */

        System.out.println("========================(While/Do-While Loops");

        //still using randomNum from above

        //while loop---\

        //WHILE the randomNumber is less than 200, the while loop will run its code block
        while(randomNum < 200){
            randomNum += 20; //increasing randomNum by 20.
            //+=? it's basically shorthand for randomNum = randomNum + 20;

            System.out.println("RandomNum has increased to: " + randomNum);
        }

        System.out.println("While Loop has broken!");

        //Do-While Loop---/

        //Do-While Loops will execute their code block ONCE, and then check the condition
        //This is a way to make sure your loop code runs at least once
        do{
            randomNum -= 20;
            System.out.println("RandomNum has decreased to: " + randomNum);
        } while (randomNum > 100);

        System.out.println("Do-While Loop has broken!");

    }

}
