package com.revature;

import com.revature.utils.JavalinAppConfig;

public class Driver {

    /*
    Our driver class has the sole responsibility of starting our application. This will contain the single main method
    in the project and will allow us to start our backend server
     */

    public static void main(String[] args) {

        // We'll create a JavalinAppConfig object, so we can create our app with the proper configuration
        JavalinAppConfig app = new JavalinAppConfig();

        // We'll start the server and allow it to listen on port 7070
        app.start(7070);
    }
}
