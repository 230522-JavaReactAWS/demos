package com.revature.controllers;

import com.revature.models.Employee;
import com.revature.service.EmployeeService;
import io.javalin.http.Context;

import java.util.ArrayList;

public class EmployeeController {
    /*
    The controller layer has the sole responsibility of taking in HttpRequests and has the responsibilty of sending the
    corresponding response.

    For our responses, best practice will be to return an appropriate message in the response body and have the proper
    status code

    Just like before we essentially want to map our CRUD methods to handlers

    TODO Create handlers for the following:
    Create
    Read (All)
    Read (One)
    Update
    Delete

    We'll be implementing the create and read all methods and adding stubs for the rest of them
     */

    private static final EmployeeService employeeService = new EmployeeService();

    public static void handleGetAll(Context ctx){
        // Inside here we need to make a call to our Employee Service to get us all the employees listed
        ArrayList<Employee> employees= employeeService.getAllEmployees();

        String result = "";

        for (Employee e: employees){
            result += e.toString() + "\n";
        }

        ctx.status(200);
        ctx.result(result);

    }

    public static void handleCreate(Context ctx){
        ctx.result("Hello World from the employee controller");
    }
}
