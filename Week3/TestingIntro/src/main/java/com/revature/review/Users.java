package com.revature.review;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Objects;

public class Users{

    private String username;

    private String password;

    private int number;

    public Users(){
        this.username = "username";
        this.password = "password";
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static void main(String[] args) {
        login("Username", "password");
    }

    public static void login(String username, String password){


        HashSet<Integer> numberSet = new HashSet<>();

        numberSet.add(6);
        numberSet.add(3);
        numberSet.add(51);
        numberSet.add(51);

        for (Integer x :numberSet){
            System.out.println(x);
        }



    }


    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(username, users.username) && Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
