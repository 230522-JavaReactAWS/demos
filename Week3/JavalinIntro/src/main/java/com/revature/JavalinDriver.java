package com.revature;

import io.javalin.Javalin;
import io.javalin.http.ForbiddenResponse;
import io.javalin.http.NotFoundResponse;

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
                    String body = ctx.body();
                    names.add(body);
                    // Collections.sort(names);
                    ctx.result("Name successfully added");
                    ctx.status(201);
                })
                .put("/", ctx -> {
                    // How do we update the list?
                    // Check if name is in list
                    // If so, replace

                    // Left an exercise to the viewer
                    UpdateNameDAO ud = ctx.bodyAsClass(UpdateNameDAO.class);

                    if (names.contains(ud.previousName)){
                        names.remove(ud.previousName);
                        names.add(ud.newName);
                        ctx.status(200);
                        ctx.result("Successful update of name!");
                    } else{
                        ctx.status(400);
                        ctx.result(ud.previousName + " was not found!");
                    }

                })
                .delete("/", ctx-> {
                    // To delete a name from our list we need to do two things

                    // First check if it in the list
                    // Then delete if it is
                    String name = ctx.body();

                    if(names.contains(name)){
                        // Name is in list so we delete
                        names.remove(name);
                        ctx.status(200);
                        ctx.result("Successfully deleted: " + name);
                    } else{
                        // Name is not in list so this is a bad request
                        ctx.result("Name is not in list!");
                        ctx.status(400);
                    }
                })
                // We changed the order of this to be declared before the path /{id}
                //http://localhot:7070/query?username=SomeNameHere
                .get("/query" , ctx -> {
                    // Let's look at a query parameter
                    // These are mainly used for filtering a specific resource (think search bars)
                    String username = ctx.queryParam("username");

                    // One of the reasons to be careful with query parameters is that they might container sensitive
                    // information that would then be on display
                    String password = ctx.queryParam("password");

                    ctx.result(username + " tried to access the page! And their password is " + password);
                })
                // Adding in a new method to test our path parameters
                // This path that we're accepting traffic on is http://localhost:7070/{id}
                .get("/{id}", ctx -> {
                    String id = ctx.pathParam("id");
                    // Let's find out if we're on the "list"

                    // we just need to search out List to see if it contains our name
                    boolean onList = names.contains(id);

                    if (onList){
                        ctx.result(id + " is on the list!");
                    } else {
                        ctx.result("You're not on the list!");
                        ctx.status(404);
                    }
                });

        app.start(7070);


    }
}

class UpdateNameDAO{
    String previousName;

    String newName;

    UpdateNameDAO(String previousName, String newName){
        this.previousName = previousName;
        this.newName = newName;
    }

    public UpdateNameDAO() {
    }

    public String getPreviousName() {
        return previousName;
    }

    public void setPreviousName(String previousName) {
        this.previousName = previousName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}
