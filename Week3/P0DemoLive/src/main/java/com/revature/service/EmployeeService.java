package com.revature.service;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeDAOInterface;
import com.revature.models.Employee;

import java.util.ArrayList;

public class EmployeeService {

    // These classes are used to provide the business logic for the application
    // They'll get called in the controller layer and call the dao layer one or multiple times to interact with the db
    // These are bridges between controllers and daos


    /* In a normal full CRUD api you'll have methods that will call on all your dao crud methods
     Create
     Read (All)
     Read (One)
     Update
     Delete

     We do not have all of these methods done
     We have the ability to Read all and the ability to create

      So we'll create service methods for each of these
     */

    // First thing we need so we can use our DAO is the dao itself
    // Follows Interface name = new Implementation()
    // List<String> names = new ArrayList<>();
    private final EmployeeDAOInterface employeeDao = new EmployeeDAO();

    // Now that we have that lets use it for our service methods
    public ArrayList<Employee> getAllEmployees(){
        // There's no "extra" business logic for this method *yet* but we may add other things later
        return employeeDao.getAllEmployees();
    }

    // Now we need to make a method for inserting an employee
    // NOTE: The employee object will be created in the CONTROLLER layer, so we're not creating it here
    // So we should expect a valid Employee object to be passed to this method
    public Employee createNewEmployee(Employee emp){
        return employeeDao.insertEmployee(emp);
        // When our controller layer receives this object it should have a different response based off whether
        // the object is null or not. For you savvy java users, you can look into using the Optional class for this
    }
}
