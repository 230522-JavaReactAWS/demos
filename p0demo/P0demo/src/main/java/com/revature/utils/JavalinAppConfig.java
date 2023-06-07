package com.revature.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.RoleController;
import io.javalin.Javalin;
import io.javalin.json.JsonMapper;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinAppConfig {

    /*
    We'll leverage this class to define our routes and set up the configuration for our Javalin app
    Why are we doing it here and not in our driver class? Unrelated code should remain separated, since this class
    is for configuration, whereas the driver class is for starting our app, it actually makes more sense to separate
    them
     */



    // Adding some space in here, so we can format our GSON object mapper for Javalin to use.
    // I'm copying this directly from the javalin docs at https://javalin.io/documentation#configuring-the-json-mapper
    // Make sure to import everything

    Gson gson = new GsonBuilder().create();
    JsonMapper gsonMapper = new JsonMapper() {
        @Override
        public String toJsonString(@NotNull Object obj, @NotNull Type type) {
            return gson.toJson(obj, type);
        }

        @Override
        public <T> T fromJsonString(@NotNull String json, @NotNull Type targetType) {
            return gson.fromJson(json, targetType);
        }
    };

    // Let's add in instances of our controllers so we can use the methods
    private final EmployeeController employeeController = new EmployeeController();
    private final RoleController roleController = new RoleController();

    private static final Logger logger = LoggerFactory.getLogger(JavalinAppConfig.class);


    // We'll create a private usage for our Javalin app, so we can only configure it here
    // Now that we have GSON, let's update the coonfig (again pulled directly from Javalin Docs)
    private Javalin app = Javalin.create(config -> config.jsonMapper(gsonMapper))
            .before("/*", ctx -> {
              logger.info("{} request has been sent to {}", ctx.method(), ctx.fullUrl());
            })
            // This is where we're going to register our routes for our API
            // Shouldn't be too bad, just mind the lambdas and try to get an understanding of how this comes together
            // Notice these all come from Javalin's APIBuilder
            .routes(() -> {
                path("employees", () -> {
                    // Method referencing
                    get(employeeController::handleGetAll);
                    post(employeeController::handleCreate);
                    put(employeeController::handleUpdate);
                    delete(employeeController::handleDelete);
                    path("{id}", () ->{
                        get(employeeController::handleGetOne);
                    });
                });
                path("roles", () -> {
                    // Method referencing
                    get(roleController::handleGetAll);
                    post(roleController::handleCreate);
                    put(roleController::handleUpdate);
                    delete(roleController::handleDelete);
                    path("{id}", () ->{
                        get(roleController::handleGetOne);
                    });
                });
            });


    // We'll have a single public method called start to start our Javalin app, this will be called in the driver class
    public void start(int port){
        app.start(port);
    }
}
