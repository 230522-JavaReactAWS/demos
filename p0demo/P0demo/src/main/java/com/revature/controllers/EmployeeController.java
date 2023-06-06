package com.revature.controllers;

import com.revature.models.Employee;
import com.revature.service.EmployeeService;
import io.javalin.http.Context;

import java.util.ArrayList;

public class EmployeeController {
    /*
    Time for us to build the long awaited Controller classes. These fun guys are in charge of just a few things
     - They take in Http Requests
     - They call service methods when necessary
     - They return Http Responses with proper status codes and the like, most times the body with be some sort of JSON
        object
     These methods should map up with your services and the paths you plan to have for your Javalin app, there will be
     some we just create stubs for, but in your project it's likely you'll have this filled out
     */

    // Before we call our methods we'll need an EmployeeService object to call those methods
    private final EmployeeService employeeService = new EmployeeService();

    // Each of these methods should return void and take in the Context object from Javalin, so we can handle our Http
    // Requests and send the appropriate responses

    // This first method should handle what happens when someone wants to get all the employees
    public void handleGetAll(Context ctx){
        // Call the service method to get all employees
        ArrayList<Employee> employees = employeeService.getAllEmployees();

        // Convert that list to json and send it as the response, since the default status is 200, we should be good
        ctx.json(employees);
    }

    // This next method should handle inserting a new employee
    public void handleCreate(Context ctx){
        // Let's get the JSON object from the context and deserialize it into an Employee object
        Employee employeeToBeAdded = ctx.bodyAsClass(Employee.class); //Make sure you have a no args and getters and
                                                                        // setters

        // Attempt to register employee
        Employee registeredEmployee = employeeService.insertEmployee(employeeToBeAdded);

        // Now we need to validate the employee returned isn't null, because that means something went wrong
        if (registeredEmployee != null){
            // This means we were successful
            ctx.status(201); // Successful creation status code
            ctx.json(registeredEmployee); // Send the registered employee as a result, the id should be positive
        } else{
            // Uh oh something went wrong, and it wasn't out fault (probably), we should tell them they sent a bad
            // request with a 400 status code
            ctx.status(400);
        }
    }

    // All the methods below aren't implemented in our service layer, so we'll just add stubs for them showing the
    // method they're trying to use isn't allowed for whatever reason with a status 405

    public void handleGetOne(Context ctx){
        ctx.status(405);
    }

    public void handleUpdate(Context ctx){
        ctx.status(405);
    }

    public void handleDelete(Context ctx){
        ctx.status(405);
        // Possible implementation activity
    }



}
