package com.revature.models;

public class Player implements IPlayer {

    private String name;
    private String weapon = "No Weapon";
    private String armor = "No Armor";
    private int health = 100;

    public void dance(String danceMove){
        System.out.println(name + " dances with " + danceMove);
    }

    @Override
    public void fight() {
        System.out.println(name + " is fighting with: " + weapon + " and " + armor);
    }

    @Override
    public String craft(String item, String material) {
        return material + " " + item;

        //why " "?

        //ironsword
        //iron sword
    }

    //in this case, we only need a constructor with name, because the other fields are default
    //in other words, we only want the user to be able to choose the name when we start
    public Player(String name) {
        this.name = name;
    }

    //in case we want a fully customized character on instantiation
    public Player(String name, String weapon, String armor, int health) {
        this.name = name;
        this.weapon = weapon;
        this.armor = armor;
        this.health = health;
    }

    //Good note to remember: every class has a default no-args constructor UNTIL one is defined
    //so before we wrote the two constructors above, there WAS a default no-args constructor


    //why getters and setters?

    //getters - get (access) the values of variables
    //setters - change/store the values of variables

    //ENCAPSULATION - the data is protected by the private access modifier
    //But, still accessible through getters and setters. The ONLY ways to access or change the data
    //We want to make sure data is not accessed or changed on accident.
    //There are specific ways to access or change data (getters/setters)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    //without the toString, we would get a memory address if we tried to print a Player object
    //WITH the toString, we get the String you see below Player{var1=value1, var2=value2 ...}
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", weapon='" + weapon + '\'' +
                ", armor='" + armor + '\'' +
                ", health=" + health +
                '}';
    }
}
