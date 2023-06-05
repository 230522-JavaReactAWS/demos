package com.revature;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavalinDriver {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Ali");
        names.add("David");
        names.add("Rafael");

        var app = Javalin.create(/*config*/)
               // Method referencing, worry about it later
               // TODO explain method referencing
               // .get("/", SampleController::handleGet)
                .get("/", ctx -> {
                    String response = "";
                    Collections.shuffle(names);
                    for (String s: names){
                        response += s + "\n";
                    }
                    ctx.result(response);
                })
                .post("/", ctx -> {
                   // TODO Add request body to list of names
                    String body = ctx.body();
                    names.add(body);
                    // Collections.sort(names);
                    ctx.result("Name successfully added");
                    ctx.status(201);
                })
                .put("/sample-put", ctx -> ctx.result("We use PUT to update records"))
                .delete("/sample-delete", ctx-> ctx.result("DELETE is used to remove records from our data"))
                .start(7070);
    }
}
