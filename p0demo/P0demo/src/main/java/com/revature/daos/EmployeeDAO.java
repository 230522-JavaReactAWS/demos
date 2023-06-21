package com.revature.daos;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO implements EmployeeDAOInterface{


    @Override
    public ArrayList<Employee> getAllEmployees() {

        //Instantiate a Connection object so that we can talk to the DB
        try(Connection conn = ConnectionUtil.getConnection()){

            //A String that represents our SQL statement
            String sql = "SELECT * FROM employees";

            /* No variables are needed in the SQL query above. No need for a PreparedStatement!
             Instead, we'll use a regular Statement object
             BIG PICTURE: If we have no variables, Statement is fine, otherwise we need PreparedStatement */
            Statement s = conn.createStatement();

            //Now, execute the query, and save the results in a ResultSet
            ResultSet rs = s.executeQuery(sql);

            //Instantiate an empty ArrayList that will hold our incoming Employee data
            ArrayList<Employee> employeeList = new ArrayList<>();

            //Instantiate a RoleDAO so we can get a Role object for our Employee objects
            RoleDAO rDAO = new RoleDAO();

            /* use rs.next() in a while loop to create a new Employee for every incoming Employee from the DB
             rs.next() ITERATES through the list of data. It will return false when there's no more data
              In other words, rs.next() returns true as long as there is new data to look at */
            while(rs.next()){

                //For every Employee record returned from the DB, make a new Employee object
                Employee employee = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rDAO.getRoleById(rs.getInt("role_id_fk"))
                        //we needed to retrieve a Role object this way, because the DB just returns the int PK
                        //"use the getRoleById method to return a role object using the role_id_fk"
                );

                //for every new Employee, add it to the ArrayList
                employeeList.add(employee);

                //by the time this while loop breaks (when rs.next() == false), our ArrayList will be full

            }

            return employeeList; //after all that nonsense above, we return our fully populated ArrayList

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