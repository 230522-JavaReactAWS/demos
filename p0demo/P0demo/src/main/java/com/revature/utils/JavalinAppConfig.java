package com.revature.utils;

import io.javalin.Javalin;

public class JavalinAppConfig {

    /*
    We'll leverage this class to define our routes and set up the configuration for our Javalin app
    Why are we doing it here and not in our driver class? Unrelated code should remain separated, since this class
    is for configuration, whereas the driver class is for starting our app, it actually makes more sense to separate
    them
     */

    // We'll create a private usage for our Javalin app, so we can only configure it here
    private Javalin app = Javalin.create();

    // We'll have a single public method called start to start our Javalin app, this will be called in the driver class
    public void start(int port){
        app.start(port);
    }
}
