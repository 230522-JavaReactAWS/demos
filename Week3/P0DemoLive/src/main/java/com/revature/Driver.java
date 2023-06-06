package com.revature;

import com.revature.controllers.EmployeeController;
import io.javalin.Javalin;

public class Driver {

    // This driver has the sole responsibility of starting our Javalin application, in a perfect world this will likely
    // contain the ONLY main method in our application

    public static void main(String[] args) {

        Javalin app = Javalin.create().get("/", EmployeeController::handleGetAll).start(7070);

    }
}
