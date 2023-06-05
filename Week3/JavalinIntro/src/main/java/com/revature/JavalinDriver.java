package com.revature;

import io.javalin.Javalin;

public class JavalinDriver {

    public static void main(String[] args) {
       var app = Javalin.create(/*config*/)
               // Method referencing, worry about it later
               // TODO explain method referencing
                .get("/", SampleController::handleGet)
                .post("/sample-post", ctx -> {
                   ctx.result("You sent a POST request!");
               })
                .start(7070);
    }
}
