package com.revature;

import io.javalin.Javalin;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

public class SessionController {

    public static void main(String[] args) {
        // We want to essentially attempt to log in a user to our server so then they can access some sort of info
        // This info is usually hidden behind some authentication barrier (to valididate someone has access to that
        // resource)

        Javalin app = Javalin.create();


        // Let me define a post request that will allow me to "log in"

        app.post("/login", ctx -> {
            // In here I'm going to pass a username and a password

            // We're using form params to take in data
            String username = ctx.formParam("username");
            String password = ctx.formParam("password");

            // We'll return that data to the user to show we can access it
//            ctx.result("Username: " + username + ". Password: " + password);

            // Normally at this point we'd call some authentication method to validate that this user exists
            // Let's validate the user and then store it in the session if the info is correct

            if (isValidUser(username, password)){


                // To store the user in the session we need to get the current session from the request that was sent
                // We'll pull of the session from the request
                HttpSession session = ctx.req().getSession(true);
                // Ctx is Context Object which contains both request and response, we need to pull the current session
                // off the request

                // Store user information inside the session itself
                session.setAttribute("username", username);
                session.setAttribute("loggedIn", true);

                ctx.result("Valid Login credentials");

            } else{
                ctx.result("Invalid Login Credentials");
                ctx.status(403);
            }
        });

        // So now that we can log in, let's create a page that will allow us to see our specific information
        app.get("/dashboard", ctx ->{

            // So we need to get the current session from the request which will allow to decrypt out JSESSIONID cookie
            HttpSession session = ctx.req().getSession(false); // Why false? We don't want to create a new session

            // Now we need to check if the user is actually logged in
            if (session != null && session.getAttribute("loggedIn") != null){
                // Let's retrieve the user info from the session

                String username = (String) session.getAttribute("username");

                // Return the username to show they've logged into their page
                ctx.result("Hello " + username + ", welcome to your page!");
            } else{
                ctx.result("Please log in to view this page");
                ctx.status(403);
            }

        });

        // Let's also add a logout feature
        app.get("/logout", ctx ->{
            // Inside here we want to pretty clear the session that is currently in use
            // This is called invalidating the session

            // Get the session
            HttpSession session = ctx.req().getSession(false);

            // Invalidate the session
            if (session != null && session.getAttribute("loggedIn") != null){
                session.invalidate();
                ctx.result("You have been logged out!");
            } else{
                ctx.result("You need to be logged in to be logged out!");
            }
        });

        app.start(8080);
    }

    public static boolean isValidUser(String username, String password){
        // Creating a map to store some dummy username password pairs
        Map<String, String> credentials = new HashMap<>();

        credentials.put("bserf", "Password123");
        // If statement to check if the username is in the list
        if (credentials.containsKey(username)){
            // This check if the associated password matches what was entered
            if(credentials.get(username).equals(password)){
                return true;
            }
        }

        return false;
    }
}
