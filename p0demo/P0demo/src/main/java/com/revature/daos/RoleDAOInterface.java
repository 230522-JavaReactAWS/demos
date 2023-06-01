package com.revature.daos;

import com.revature.models.Role;

//This Interface will lay out the methods that the RoleDAO Implements
//This is a great way to document what functionalities exist in the RoleDAO
public interface RoleDAOInterface {

    //a method that SELECTS a Role by its ID
    Role getRoleById(int id);

    //a method that UPDATEs a Role's salary
    //I'll write this out later

}
