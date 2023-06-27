package com.revature;

import com.revature.models.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Launcher {

    public static void main(String[] args) {

        /* This is the beginning of a harrowing Java adventure -
        -Create a Player Class by implementing the IPlayer Interface.
        -All Players should have:
            -name
            -weapon = "No Weapon"
            -armor = "No Armor"
            -health = 100


        -Instantiate your Player below, ONLY giving it a name
        -Print out "[player name] was born!" */
        Player p1 = new Player("Billy");

        System.out.println(p1.getName() + " was born");







        /* Despite you just being born, you're surrounded by wolves!! Where are your parents?

          -fight() them off!!!
                _
               / \      _-'
             _/|  \-''- _ /
        __-' { |          \
            /             \
            /       "o.  |o }
            |            \ ;
                          ',
               \_         __\
                 ''-_    \.//
                   / '-____'
                  /
                _'
              _-'*/

        p1.fight();











    /*You barely survive, losing 90 health in the fight
     -Set player health to 10, and print out remaining health*/

    p1.setHealth(10);

    System.out.println(p1.getHealth() + " Wahhhh ");






    /* Welcome to the Aspirin merchant! Fighting wolves always leaves me with a headache...

    "You may take some Aspirin by solving my riddle nyahahahaha" says the merchant.

    "Declare an int that is not quite an int, but its OBJECT representation.
     use it to assign your health to 200 - such is the Aspirin incantation"

         _____
        [IIIII]
         )"""(
        /     \
       /       \
       |`-...-'|
       |aspirin|
     _ |`-...-'j    _
    (\)`-.___.(I) _(/)
      (I)  (/)(I)(\) */


    Integer newHealth = new Integer(200);

    p1.setHealth(newHealth);


    //How refreshing!
    System.out.println(p1.getHealth());











        /* Welcome to the blacksmith! It's time for some upgrades.
        -Craft and assign yourself a weapon and armor using the craft() method⠀⠀⠀⠀
        -Check out your new gear by printing it
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⢠⣄⣤⣦⣤⣀⣀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠛⠿⠟⠈⠉
⠀⠀⠀⠀⠀⠀⠀⠀⣠⠀⠘⢿⣿⠟⠀⢠⡀⠀⠀⠀⠀⠀⠀⠀⣰⡗⠀⠀⠀⠀
⠀⠀⠀⠀⠀⢠⣾⠀⣿⠀⣷⣦⣤⣴⡇⢸⡇⠀⣷⠀⠀⠀⠀⣰⡟⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⣿⣿⠀⣿⣤⣈⣉⣉⣉⣠⣼⡇⠀⣿⡆⠀⠀⣰⡟⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⣿⠇⠀⠀⠛⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠛⠛⠀⠛⠛⠛⠛⠛⠛⠛⠛⠃⠀⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⣤⣤⣤⣤⣤⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠈⠙⠛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠿⠇⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠘⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠃*/

    p1.setWeapon(p1.craft("Scimmy", "Dragonscale"));

    p1.setArmor(p1.craft("Breastplate", "Dragonscale"));


    System.out.println(p1.getWeapon() + " " + p1.getArmor());








    /*You encounter an angry Wizard! He looks like he's got unhandled problems.

    "I pity you traveler, for you will be the new bearer of my burden... TRY to handle THIS!!!"

    handle the Wizard's spell, and finally, fight() back!

         __/\__
    . _   \''/
    -( )-/_||_\
     .'. \_()_/
      |   | . \
      |   | .  \
     .'. ,\_____'. */

       /*~~~BOOM~~~*/

    //throw new Exception();
    //This ^ is a CHECKED EXCEPTION - the compiler will notice right away, and won't let you compile

       try{
           int x = 2/0;
           //UNCHECKED/RUNTIME EXCEPTION
           //the compiler does not notice it until it runs, it will let you compile

           System.out.println("I won't run, but the compiler doesn't know that");
           System.out.println("Because it can't see unchecked exceptions until it actually runs");

       } catch(ArithmeticException e){
           e.printStackTrace(); //remember, this is what tells us our error message
       } finally{
           p1.fight();
       }














    /* "WOW!! My curse has been lifted. I wish you didn't hit me back though.
    Anyway, I will reward you if you can solve my riddle -

    "Make me a sequence of 1, 2, and 3 - ordered and indexed this structure must be.
    Print the second element of this creation - or else you shall suffer eternal damnation."
         __/\__
    . _   \^^/
    -( )-/_||_\
     .'. \_()_/
      |   | . \
      |   | .  \
     .'. ,\_____'. */

    //As we know, Lists are ORDERED and INDEXED
    //remember, <generics> gives us the flexibility to define the data type during instantiation
    ArrayList<Integer> numbers = new ArrayList<>();

    numbers.add(1);
    numbers.add(2);
    numbers.add(3);

    System.out.println(numbers.get(1)); //remember, ZERO INDEXED

    //let's see this with an Array

    int[] numbers2 = {1, 2, 3};

    System.out.println(numbers2[1]);

    System.out.println(numbers); //ArrayLists have a built-in toString
    System.out.println(numbers2); //Arrays don't, we would need to call it from the Arrays Class






    /*After solving the wizard's riddle, he vanishes in a puff of bytecode!!
      A chest lays at your feet! :O
         _-_______-
        /\____;;___\
       | /         /
       `. ())oo() .
        |\(%()*^^()^\
       %| |-%-------|
      % \ | %  ))   |
      %  \|%________|

      -Iterate through the chest's loot
      -Choose (print out) only the favorable items
      -Skip the unfavorable items */

      String[] items = {"Monster Energy", "Two dollars", "Two doll hairs", "Puppy", "The Goop",
              "Cousin Timothy", "Three McChickens", "The Declaration of Independence",
              "Staff of Plot Thickening"};


      //we can use for loops to iterate through sequences of values (Array, List, etc)
      for(int i = 0; i < items.length; i++){

          //two ways to skip things in an Array:

          if(items[i].equals("The Goop")){
              continue; //continue skips a loop's iteration and moves on to the next loop
              //"continue immediately. don't do the rest of the loop"
          }

          //This way is more scalable if we want to skip multiple things (faster to write)
          if(items[i] != "Cousin Timothy"){
              System.out.println(items[i]);
          }

      }

        //we could have also done an enhanced for loop
        //"for every item in items, do something"
        for(String item : items){
            //do something
        }

        //how are these for loops the same?
        //They're both looping as many times as there are elements in the Array
        //they loop as many times as the length of the Array








      /*"The Staff of Plot Thickening? Better use this since I'm out of ideas for smooth transitions"

      Upon using the Staff, an imp appears!! "Myahhh! I am an Imp named Slickback"

        "Your name is Slickback?" You query.

        "NO! My name is an Imp named Slickback. And for your impudence,
        you must now answer my riddle lest I gnaw on your ankles!!"
              ,      ,
        |\   /(.-""-.)\ /|
        | \ / =.  .= \ / |
        \( \   o\/o   / )/
         \_, '-/  \-' ,_/
           /   \__/   \
           \ \__/\__/ /
            \ \|--|/ /

        "What can we use, to let devs choose, datatypes during instantiation?
        it's used in collections, and it's my perception that it lends to code flexibility"

        *The imp is unaware that the riddle didn't rhyme*
       */




      //the answer is generics! See the ArrayList<> above for an example of <generics>












        /*Despite your correct answer, the imp betrayed you!! You're fighting!!!

              O                                     O
        {o)xxx|===============-  *  -===============|xxx(o}
              O                                     O

        -Uhhhh let's go with turn based combat. Okay yeah.
        -While imp health is > 0, invoke fight() and subtract 20 from both fighter's health
        -After the fight, print out your own health */

        int impHealth = 100;

        while(impHealth > 0){

            p1.fight();

            p1.setHealth(p1.getHealth() - 20);
            impHealth -= 20; //this is a short way of saying impHealth = impHealth - 20;

        }

        System.out.println(p1.getHealth());








        /*You're hurt, but the surgeon general recommends no more than 12 tablets of Aspirin
        per 24 hours. Better wander into the nearest tavern for a drink instead.

                            ________[_]________
                   /\      /\        ______    \
                  /  \    //_\       \    /\    \
           /\    / /\/\  //___\       \__/  \    \
          /  \  /\/    \//_____\       \ |[]|     \
         /\/\/\/       //_______\       \|__|      \
        /      \      /XXXXXXXXXX\                  \
                \    /_I_II  I__I_\__________________\
                       I_I|  I__I_____[]_|_[]_____I
                       I_II  I__I_____[]_|_[]_____I
                       I II__I  I     XXXXXXX     I

        "How many riddles does a guy have to answer to get some mead?" You ask

        "Just one, as usual!" Replies the innkeeper

        "This non access mod makes beginners sob, so faint of heart beware...
        It makes a variable belong to the Class, and its value between objects is shared" */


        //static!

        //members that are static scoped BELONG TO THE CLASS. They are CLASS SCOPED
        //conversely, NONSTATIC members BELONG TO THE OBJECT
        //static = value is shared; nonstatic = value is unique between objects.

        //you cannot refer to NONSTATIC MEMBERS from within STATIC METHODS

        //Player.fight(); //fight() is not static!!
        //Player.name; //same
        //we could only access the fight() method if we made a Player object first

        //we cannot call nonstatics from the Class; we CAN call them from objects








        /* That wasn't so hard, was it?

                  )  (o
                ( o  ) )
                 ) ( (o
                ooooooooo
             .-'---ooooo-|
            ( C|/\/\/oo\/|
             '-./\/\/\o\/|
               '_________'
                '-------'

        You're bubbly. It's time to dance!! Except you don't know how...

        Implement a new method in the Player Class called dance() to learn how to dance!
        -The dance method has no return type takes a String danceMove as a parameter. Call it below.

        */

        p1.dance("the robot");










/*
                      _____
        ⊂_ヽ _        |    |
             ＼＼    _|_____|_
               \ ＼ ( ͡° ͜ʖ ͡°)
                 _    >    ⌒ヽ
                    /      へ＼
                 /        /    ＼＼
                 ﾚ    ノ         ヽ_つ
                /    /
             /    /|
            (    (ヽ
            |    |、＼
            | 丿 ＼ ⌒)
            | |        )
            (_／
        you're magnificent.



        The audience is getting involved!
        They're shouting out an UNORDERED COLLECTION of dance moves with NO DUPLICATES!!

        Ok audience... instantiate that Collection, and fill it with some dance moves.
        For each dance move in the Collection, call the dance method!
        */


        HashSet<String> danceMoves = new HashSet<>();

        danceMoves.add("Cabbage Patch");
        danceMoves.add("Riverwalk");
        danceMoves.add("Waltz");
        danceMoves.add("Electric Slide");

        //for int i, which starts at 0,
        //as long as i is less than the size of the danceMoves Set,
        //increment i by 1 per loop
        //WE ARE ITERATING THROUGH THE DANCEMOVES SET (one by one)
        for(int i = 0; i < danceMoves.size(); i++){

            //this is a perfectly fine for loop, but SETS HAVE NO INDEXES!!
            //so we can't actually access the elements of the set in this way

            //this would be better to use if we had an indexed Collection
        }

        //to iterate through Sets, we may be better serves by an enhanced for loop
        //since they just go through the set without worrying about indexes
        //"For every element in the set, do something"
        for(String danceMove:danceMoves){
            p1.dance(danceMove);
        }








    /*  All this stimulation is HYPING YOU UP. Time for a good old fashioned bar brawl.

         "HOW MANY OF YOU MILK DRINKERS WANNA CATCH SOME HANDS?" You inquire politely...

         There were 10.

         (ง'̀-'́)ง (ง'̀-'́)ง (ง'̀-'́)ง (ง'̀-'́)ง (ง'̀-'́)ง (ง'̀-'́)ง (ง'̀-'́)ง (ง'̀-'́)ง (ง'̀-'́)ง (ง'̀-'́)ง

        You're getting absolutely stomped out by 10 tavern patrons! You've accepted your fate.

        -Everyone is getting a hit in!
        -For every patron, subtract 15 from your health.
        -If your health is less than or equal to 0 after any hit, you die and the loop breaks! */

        for(int i = 0; i < 10; i++){

            p1.setHealth(p1.getHealth() - 15);

            /* We could have also done it this way, which may be easier to understand

            int h = p1.getHealth() - 15;
            p1.setHealth(h);

             */

            //break the loop if our health reaches 0 or less
            if(p1.getHealth() <= 0){
                System.out.println(p1.getName() + " HAS PERISHED!!!");
                break; //ack I died
            }

        }








     /* ███▀▀▀██┼███▀▀▀███┼███▀█▄█▀███┼██▀▀▀▀
        ██┼┼┼┼██┼█┼┼┼┼┼┼┼█┼██┼┼┼█┼┼┼██┼██┼┼┼
        ██┼┼┼▄▄▄┼██▄▄▄▄▄██┼██┼┼┼▀┼┼┼██┼██▀▀▀
        ██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██┼┼┼
        ███▄▄▄██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██▄▄▄▄
        ┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼
        ███▀▀▀███┼▀███┼┼██▀┼██▀▀▀┼██▀▀▀▀██▄┼
        ██┼┼┼┼┼██┼┼┼██┼┼██┼┼██┼┼┼┼██┼┼┼┼┼██┼
        ██┼┼┼┼┼██┼┼┼██┼┼██┼┼██▀▀▀┼██▄▄▄▄▄▀▀┼
        ██┼┼┼┼┼██┼┼┼██┼┼█▀┼┼██┼┼┼┼██┼┼┼┼┼██┼
        ███▄▄▄███┼┼┼─▀█▀┼┼─┼██▄▄▄┼██┼┼┼┼┼██▄

      O                                     O
{o)xxx|===============-   *   -===============|xxx(o}
      O                                     O           */


    }

}
