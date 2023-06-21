package com.revature.models;

//This Class is basically a duplicate of the Player Class, just for the sake of drilling practice

public class Player2 implements IPlayer{

    private String name;
    private String weapon = "No Weapon";
    private String armor = "No Armor";
    private int health = 100;

    @Override
    public void fight() {
        System.out.println(name + " is fighting with: " + weapon + " and " + armor);
    }

    @Override
    public String craft(String item, String material) {
        return material + " " + item;

        //e.g. "bronze axe", "leather cap"
    }

    public Player2(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "Player2{" +
                "name='" + name + '\'' +
                ", weapon='" + weapon + '\'' +
                ", armor='" + armor + '\'' +
                ", health=" + health +
                '}';
    }
}
