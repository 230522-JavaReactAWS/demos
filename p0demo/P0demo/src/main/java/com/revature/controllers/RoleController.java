package com.revature.controllers;

import com.revature.models.Role;
import com.revature.service.RoleService;
import io.javalin.http.Context;

public class RoleController {
    /*
    The role controller is similar to the employee controller in the sense that it's the hub for http requests and
    responses pertaining directly to the Role objects. We'll implement the methods in line with our service layer and
    leave the rest as stubs
     */

    // Let's get a RoleService object in here to get started
    private final RoleService roleService = new RoleService();

    // Much like the employee controller, our RoleController methods should return void and take in the Context obejct
    // as an argument
    public void handleGetOne(Context ctx){
        // This should give us the specific role at the path "http://localhost:7070/roles/{id}"
        // Note that the id is a path parameter since we only want the one and not all roles

        // We'll need to make sure the id is actually a number, if it isn't then we'll just throw a bad request and end
        // the method by returning (note that we don't return a value because void)
        int id;
        try{
             id = Integer.parseInt(ctx.pathParam("id"));
        } catch (NumberFormatException e){
            ctx.status(400);
            return;
        }

        // Now we can call the service to get this checked out
        Role role = roleService.getRoleById(id);

        // Now we need to make sure our role is not null, if it isn't, we can return the role and call it a day,
        // otherwise we're returning a 404 since that role can't be found
        if (role != null){
            ctx.status(200);
            ctx.json(role);
        } else{
            ctx.status(404);
        }
    }

    // Our next method involves updating a role. Since we can describe a role with just salary and title, we're good
    // Otherwise we might need to make a DTO to describe the format of our data (if you're curious ask bryan during
    // lecture)

    public void handleUpdate(Context ctx){
        // Get the role from the body and use GSON to deserialize it
        Role submittedRole = ctx.bodyAsClass(Role.class);

        // Call the role service method and use the response to indicate our response
        boolean updateSuccessful = roleService.updateRoleSalary(submittedRole.getRole_salary(),
                                                                submittedRole.getRole_title());

        if (updateSuccessful){
            ctx.status(200);
        } else {
            ctx.status(400);
        }
    }


    // All the following are method stubs for the remaining methods we should complete if we have the ability
    public void handleGetAll(Context ctx){
        ctx.status(405);
    }

    public void handleCreate(Context ctx){
        ctx.status(405);
    }

    public void handleDelete(Context ctx){
        ctx.status(405);

    }
}
