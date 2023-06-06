package com.revature;

import com.revature.controllers.EmployeeController;
import com.revature.utils.JavalinAppConfig;
import io.javalin.Javalin;

public class Driver {

    // This driver has the sole responsibility of starting our Javalin application, in a perfect world this will likely
    // contain the ONLY main method in our application

    public static void main(String[] args) {

        // Create a new instance of the Javalin Config class
        JavalinAppConfig app = new JavalinAppConfig();

        // Start the app with app.start
        app.start(7070);

    }
}
