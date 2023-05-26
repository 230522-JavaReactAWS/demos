package com.revature.models;

import com.revature.exceptions.NotACookieException;

//This Class will model a monster that only eats cookies. A cookie monster if you will
//It has methods that will take in a Food object, and throw an Exception if it is not a cookie
public class CookieEatingMonster {

    public void eatCookieWithTryCatch(Food food) {

        try{ //try to eat a cookie...

            if(food.isCookie){ //if the food is a cookie...
                System.out.println("Thanks for the cookie omnomnom");
            } else { //if the food is NOT a cookie...
                throw new NotACookieException("I only eat COOKIES");
                //what is "throw new"? This is us literally creating and throwing an Exception
                //this will crash our application if not handled correctly
            }

        }
        catch(NotACookieException e){ //if the food is not a cookie, and exception will be thrown
            System.out.println("Exception Caught!");
            e.printStackTrace(); //print an error message to the console
        }

    }

    //This method THROWS NotACookieException, which makes it not responsible for that Exception
    //If NotACookieException gets thrown here, it will be the responsibility of the method that called it
    public void eatCookieWithThrows(Food food) throws NotACookieException{

        if(food.isCookie){
            System.out.println("Thanks for the delicious cookie. OMNOMNOM");
        }else{
            throw new NotACookieException("Do not feed me anything other than cookies.");
        }
    }

}
