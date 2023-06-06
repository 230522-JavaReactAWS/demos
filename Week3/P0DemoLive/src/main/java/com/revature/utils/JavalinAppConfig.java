package com.revature.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.controllers.EmployeeController;
import io.javalin.Javalin;
import io.javalin.json.JsonMapper;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;

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

    private Javalin app = Javalin.create(config -> config.jsonMapper(gsonMapper))
                            .get("/", EmployeeController::handleGetAll);

    // To make it so the main method of the Driver class is what STARTS the application, we'll create a method that
    // allows to start the javalin app we've configured here

    public void start(int port){
        app.start(port);
    }
}
