package com.revature;

import io.javalin.Javalin;

public class JavalinDriver {

    public static void main(String[] args) {


        var app = Javalin.create(/*config*/)
               // Method referencing, worry about it later
               // TODO explain method referencing
               // .get("/", ctx -> ctx.result("Hello World"))
               .get("/", SampleController::handleGet)
               .post("/sample-post", ctx -> {
                   ctx.result("You sent a POST request!");
               })
               .put("/sample-put", ctx -> ctx.result("We use PUT to update records"))
               .delete("/sample-delete", ctx-> ctx.result("DELETE is used to remove records from our data"))
               .start(7070);
    }
}
