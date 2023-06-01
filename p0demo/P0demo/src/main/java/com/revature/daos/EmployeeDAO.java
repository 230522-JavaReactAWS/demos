package com.revature.daos;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO implements EmployeeDAOInterface{


    @Override
    public ArrayList<Employee> getAllEmployees() {
        return null;
    }


    @Override
    public Employee insertEmployee(Employee emp) {

        //REMEMBER - every DAO method must start by opening DB connection
        try(Connection conn = ConnectionUtil.getConnection()){

            //we need to create the SQL String that we're sending to the database
            String sql = "INSERT INTO employees (first_name, last_name, role_id_fk) VALUES (?, ?, ?)";

            

        } catch(SQLException e){
            System.out.println("Insert employee failed!");
            e.printStackTrace(); //tell the suer what exactly went wrong
        }

        return null;
    }
}