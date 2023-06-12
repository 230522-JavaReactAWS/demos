package com.revature;

import io.javalin.Javalin;

public class Driver {

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        // http://localhost:8000/sample
        app.get("/sample", ctx -> {
           // Inside of here is the base of where I do all my logic
           ctx.result("Hello World!");
        });

        app.start(8000);
    }
}
