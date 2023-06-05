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
                .start(7070);
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
