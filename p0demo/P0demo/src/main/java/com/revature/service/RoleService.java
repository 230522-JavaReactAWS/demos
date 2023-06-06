package com.revature.service;

import com.revature.daos.RoleDAO;
import com.revature.daos.RoleDAOInterface;
import com.revature.models.Role;

public class RoleService {
    /*
    Services are what we use to do the logic behind our CRUD functionality. Available to us in our RoleDAO are two
    methods: getRoleById and updateRoleSalary. This encompasses the read (not completely) and update functionality
    from CRUD. Since the methods we can have in our service rely on the methods we have in our DAO Layer, make sure
    you've fully implemented the CRUD methods. For this demo we'll show you the service methods for the ones we have
     */

    // The first thing we need to do get an instance of our RoleDAO, so we can actually use it
    // Recall the standard format is Interface i = new Implementation()

    private final RoleDAOInterface roleDao = new RoleDAO();

    // Now we need to consider the methods we can create with getRoleById and updateRoleSalary. Recall that this is
    // the intermediary between the controller and daos, so we should prove some validation or logic if necessary

    public Role getRoleById(int id){
        // This method should be called by the RoleController and pass in some integer, let's make sure that integer
        // is valid by making sure it's non-zero and positive

        if (id > 0){
            // This is the successful case
            // We should call our RoleDAO since we now know the id won't make it break or just return a null val
            return roleDao.getRoleById(id);
        }

        // We should be good to pass this role back to our controller now, we should expect it to send a 200 response
        // if we got the Role and a 404 if we couldn't find it (meaning the Role object we return is null)
        return null;
    }

    // Our next method will be called by the RoleController and used to update the salary of the Role
    public boolean updateRoleSalary(int salary, String title){
        // We should make sure the salary is greater than zero, and we should make sure the title is not null and format
        // the title in a way that matches how we have the data in our database, We'll do the latter first

        if (title == null){
            return false;
        }

        // If we really want to make sure our input is titlecase we'll have to write some logic to do so
        // Let's create an empty string that holds our result
        String formattedTitle = "";
        // Now let's create a char array of the original title, this will help with looping
        char[] titleArray = title.toCharArray();
        // Let's add the first character to the formatted title as a capital letter
        formattedTitle += Character.toUpperCase(titleArray[0]);
        // Loop over the rest of the array and only add a capital if the previous char was a space
        for (int i = 1; i< titleArray.length; i++){
            if (titleArray[i-1] == ' '){
                formattedTitle += Character.toUpperCase(titleArray[i]);
            } else{
                formattedTitle += titleArray[i];
            }
        }
        // This should guarantee things like "fry cook" get corrected to "Fry Cook" to match how we've stored data

        // Now let's make sure our salary is greater than zero, if it is, we're good to return the value of the DAO
        // method, otherwise, we should return false
        if (salary > 0){
            return roleDao.updateRoleSalary(salary, formattedTitle);
        }

        return false;

    }


}
