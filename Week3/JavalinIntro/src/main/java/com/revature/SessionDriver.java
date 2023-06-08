package com.revature;

import io.javalin.Javalin;
import jakarta.servlet.http.HttpSession;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class SessionDriver {

    public static void main(String[] args) {
        var app = Javalin.create();

        app.post("/login", ctx -> {
            // Retrieve the username and password from the request
            String username = ctx.formParam("username");
            String password = ctx.formParam("password");

            // Validate the credentials
            if (isValidUser(username, password)) {
                // Get the session associated with the request
                HttpSession session = ctx.req().getSession(true);

                // Store user information in the session
                session.setAttribute("username", username);
                session.setAttribute("loggedIn", true);

                // Redirect to a new page or return a success response
                ctx.redirect("/dashboard");
            } else {
                // Handle invalid credentials
                ctx.redirect("/login?error=invalid_credentials");
            }
        });

        app.get("/dashboard", ctx -> {
            // Get the session associated with the request
            HttpSession session = ctx.req().getSession(false);

            // Check if the user is logged in
            if (session != null && session.getAttribute("loggedIn") != null) {
                // Retrieve user information from the session
                String username = (String) session.getAttribute("username");

                // Render the dashboard page with the user information
                ctx.json(Map.of("username", username));
            } else {
                // Redirect to the login page if the user is not logged in
                ctx.result("Not Logged In!");
            }
        });

        app.get("/session-state", ctx -> {
            // Get the session associated with the request
            HttpSession session = ctx.req().getSession(false);

            if (session != null) {
                // Retrieve session attributes and render them
                Map<String, Object> sessionAttributes = new HashMap<>();
                Enumeration<String> attributeNames = session.getAttributeNames();
                while (attributeNames.hasMoreElements()) {
                    String attributeName = attributeNames.nextElement();
                    Object attributeValue = session.getAttribute(attributeName);
                    sessionAttributes.put(attributeName, attributeValue);
                }

                ctx.json(sessionAttributes);
            } else {
                ctx.status(404).result("Session not found");
            }
        });

        app.start(8080);

    }

    public static boolean isValidUser(String username, String password){
        return true;
    }
}
