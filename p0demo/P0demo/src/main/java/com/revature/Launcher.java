package com.revature;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.RoleDAO;
import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Launcher {

    public static void main(String[] args) {

        /*This is a try-with-resources block
         A resource (in this case, a DB connection) is opened within the parenthesis
         Another benefit is that the resource will close for us when the block completes
         This is helpful for code cleanup and preventing memory leaks*/
        try(Connection conn = ConnectionUtil.getConnection()){
            System.out.println("CONNECTION SUCCESSFUL :)");
        }
        catch(SQLException e){
            System.out.println("Connection Failed :(" );
        }


        //calling DAO methods below---------------

        //instantiate a RoleDAO object so we can use its methods
        RoleDAO rDAO = new RoleDAO();

        //getting a Role object by id
        System.out.println(rDAO.getRoleById(2));

        //try to update the role salary for Manager
        System.out.println(rDAO.updateRoleSalary(500000, "Manager"));
        System.out.println(rDAO.getRoleById(1)); //checking if the Manager salary was updated

        //Instantiate an EmployeeDAO object so we can use its methods
        EmployeeDAO eDAO = new EmployeeDAO();

        //insert a new employee (we need to instantiate it first)
        Employee marrio = new Employee("Marrio","Hinkle", 3);

        //run the insert method
        System.out.println(eDAO.insertEmployee(marrio));

    }

}
