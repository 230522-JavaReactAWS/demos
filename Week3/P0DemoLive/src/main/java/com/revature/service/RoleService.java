package com.revature.service;

import com.revature.daos.RoleDAO;
import com.revature.daos.RoleDAOInterface;
import com.revature.models.Role;

public class RoleService {

    // This is going to function the same way our employee service does but for Roles

    /*
    We need to check our DAO to see what methods we have available to work it from CRUD
    We have getRoleById and updateRoleSalary
     */

    // We need to get an instance of our RoleDAO to use it
    // private final RoleDAOInterface roleDao = new RoleDAO();
    // We're going to alter the constructor so it needs to take in a RoleDAOInterface object
    private RoleDAOInterface roleDao;

    public RoleService(RoleDAOInterface roleDao){
        this.roleDao = roleDao;
    }

    // Now we need to think about how the controller is going to call our methods

    // There are some problems if the controller layer hands us any old integer
    // We're going to add in some logic to do some validation with the information that the controller hands us
    public Role getRoleById(int id){
        // The controller doesn't care WHAT integer it hands us, it's only job is to pass the info

        if (id > 0){
            return roleDao.getRoleById(id);
        } else{
            return null;
            // Our controller will have to have some logic to print out an appropriate statement if it receives
            // a valid Role object or a null object
        }
    }


    // To update our role salary there's a couple of things we need to do first
    // TODO We need to validate that the salary is >0
    // TODO We need to find some way to make the string we're handed TitleCase otherwise there's point searching for it
    public boolean updateSalary(int salary, String title){

        // Before EVERYTHING let's make sure we have a valid string length
        if (title == null || title.trim().equals("")){
            return false;
        }

        // fry cook --> Fry Cook
        // fRY CoOK --> Fry Cook
        // Let's find a way to make our string TitleCase
        // We're going to make a bunch of string object (sorry string pool lol) to basically reconstruct the string
        // character by character

        char[] titleArray = title.toLowerCase().toCharArray();

        // Now I need a string to store the result
        String formattedTitle = "";

        // We need to add the first character as a capital letter
        // We're going to use the wrapper class Character's toUpperCase method
        formattedTitle += Character.toUpperCase(titleArray[0]);

        // Now we need to loop over the rest of the characters and if the character BEFORE the current one is a space
        // we need to capitalize that character, otherwise just add
        for (int i = 1; i< titleArray.length; i++){
            if (titleArray[i-1] == ' '){
                formattedTitle += Character.toUpperCase(titleArray[i]);
            } else {
                formattedTitle += titleArray[i];
            }
        }

        if (salary > 0){
            return roleDao.updateRoleSalary(salary, formattedTitle);
        }

        // An additional way to do this
        /*

        String[] words = title.toLowerCase().split(" ")
        String formattedTitle2 = ""
        for(String word : words){
            formattedTitle2 += Character.toUpperCase(word.charAt(0)) + word.substring(1)
         */

        return false;

    }
}
