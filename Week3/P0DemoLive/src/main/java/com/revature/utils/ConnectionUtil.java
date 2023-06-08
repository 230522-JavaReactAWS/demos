package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//This Class is where we manage and establish our database connection
public class ConnectionUtil {

    // TODO change this to a singleton design pattern to establish ONE connection and just reuse it over time

    // We need three things to make this a proper singleton class
    // private static instance of a connection --> holds the connection itself
    // private constructor --> prevents other users from making their own connections
    // public static getConnection method --> the ONLY way we want users to get the connection to the db

    // Private static instance
    private static Connection conn = null; // We initialize this to be null so there's no open connection all the time


    // private constructor
    private ConnectionUtil(){

    }


    //This method will eventually return an object of type Connection, which we'll use to connect to our databse
    public static Connection getConnection() throws SQLException {

        // Now is time for the singleton stuff to make sure we only every have one connection
        // Look to see if there is an OPEN connection

        if (conn != null && !conn.isClosed()){
            // This means the connections is NOT null and IS OPEN
            System.out.println("Using a previously created connection");
            return conn;
        }

        //For compatibility with other technologies/frameworks, we'll need to register our PostgreSQL driver
        //This process makes the application aware of what Driver class we're using
        try {
            Class.forName("org.postgresql.Driver"); //searching for the postgres driver, which we have as a dependency
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); //This tells us in the console what went wrong
            System.out.println("problem occurred locating driver");
        }


        //Use our database credentials to establish a database connection
        //Hardcoded for now - It's possible hide them in the Environment Variables, feel free to look into it

        //I'm going to put the credentials in Strings, and use those strings in a method that gets connections
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=p0demo";
        String username = "postgres";
        String password = "Sparky2014!!"; //this is the password you made when you installed Postgres

        //This return statement is what returns out actual database Connection object
        //Note how this getConnection() method has a return type of Connection
        // return DriverManager.getConnection(url, username, password);


        // Essentially at this point we can guarantee that there is not a current open connection
        conn = DriverManager.getConnection(url, username, password);


        return conn;

    }

}
