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

    // This is the class I plan to use to do ALL my Javalin configuration

    // I plan to create a PRIVATE javalin app that will hold my config information and I will start it in the driver
    // class main method

    // Before we do our configuration we need to create a GSON object mapper
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

    private static final Logger logger = LoggerFactory.getLogger(JavalinAppConfig.class);

    private Javalin app = Javalin.create(config -> config.jsonMapper(gsonMapper))
            // I want to add a log for debugging later, so I'll tell Logback to create a log
            // for every request I send to the server
            .before(ctx -> {
                // This logic here will run before ALL requests to the server
                // We want to use to log our request sent
                logger.info(ctx.method() + " Request was sent to path: " + ctx.fullUrl());
            })
            // routes will declare all our possible paths
            .routes(() ->{
                // each path will allow to group like method
                path("employees", () ->{
                    // Declare my routes and methods super quickly
                    get(EmployeeController::handleGetAll);
                    // app.get("/employees", EmployeeController::handleGetAll)
                    post(EmployeeController::handleCreate);
                    put(EmployeeController::handleUpdate);
                    delete(EmployeeController::handleDelete);
                    // What about /employees/{id}?????
                    path("{id}", () ->{
                        get(EmployeeController::handleGetOne);
                    });
                });
                path("roles", () ->{
                    // Declare my routes and methods super quickly
                    get(RoleController::handleGetAll);
                    post(RoleController::handleCreate);
                    put(RoleController::handleUpdate);
                    delete(RoleController::handleDelete);
                    // What about /roles/{id}?????
                    path("{id}", () ->{
                        get(RoleController::handleGetOne);
                    });
                });
            });

    // To make it so the main method of the Driver class is what STARTS the application, we'll create a method that
    // allows to start the javalin app we've configured here

    public void start(int port){
        app.start(port);
    }
}
