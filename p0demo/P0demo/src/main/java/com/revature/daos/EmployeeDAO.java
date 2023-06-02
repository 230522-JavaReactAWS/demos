package com.revature.daos;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO implements EmployeeDAOInterface{


    @Override
    public ArrayList<Employee> getAllEmployees() {

        //Instantiate a Connection object so that we can talk to the DB
        try(Connection conn = ConnectionUtil.getConnection()){

        } catch(SQLException e){
            System.out.println("Failed to get all employees");
            e.printStackTrace(); //detailed info in our console about what went wrong
        }

        return null;
    }


    @Override
    public Employee insertEmployee(Employee emp) {

        //REMEMBER - every DAO method must start by opening DB connection
        try(Connection conn = ConnectionUtil.getConnection()){

            //we need to create the SQL String that we're sending to the database
            String sql = "INSERT INTO employees (first_name, last_name, role_id_fk) VALUES (?, ?, ?)";

            //Instantiate a PreparedStatement to hold our SQL String and fill its variables
            PreparedStatement ps = conn.prepareStatement(sql);

            //we can now use our PreparedStatement to fill in the wildcards one by one
            ps.setString(1, emp.getFirst_name());
            ps.setString(2, emp.getLast_name());
            ps.setInt(3, emp.getRole_id_fk());

            //now that our SQL String is fully populated with data, we can execute the update
            ps.executeUpdate();

            //No data is returned in an INSERT, so no need to make a ResultSet
            //But we DO want to return the inputted employee back to the user as confirmation
            return emp;

            //if we wanted to, we could have made another DAO method to SELECT the employee we inserted
            //but this return above is fine (and a lot less work)

        } catch(SQLException e){
            System.out.println("Insert employee failed!");
            e.printStackTrace(); //tell the suer what exactly went wrong
        }

        return null;
    }
}