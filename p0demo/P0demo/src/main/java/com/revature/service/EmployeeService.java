package com.revature.service;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeDAOInterface;
import com.revature.models.Employee;

import java.util.ArrayList;

public class EmployeeService {
    /*
    Services are what we use to do the logic behind our CRUD functionality. Available to us in our EmployeeDAO are two
    methods: getAllEmployees and insertEmployees. This encompasses the read (not completely) and update functionality
    from CRUD. Since the methods we can have in our service rely on the methods we have in our DAO Layer, make sure
    you've fully implemented the CRUD methods. For this demo we'll show you the service methods for the ones we have
     */

    // The first thing we need to do get an instance of our EmployeeDAO, so we can actually use it
    // Recall the standard format is Interface i = new Implementation()

    private final EmployeeDAOInterface employeeDAO= new EmployeeDAO();

    // The first method is our getAllEmployees. In general, these methods are some of the easiest to write service
    // methods for, most times the minimum you need to do is just call the DAO method and pass it back up to the
    // service layer. This will get more complex as we add in things like logging and authentication

    public ArrayList<Employee> getAllEmployees(){
        return employeeDAO.getAllEmployees();
    }

    // Insert employee actually should be alright too, we'll rely on GSON to map the object passed in the HttpRequest
    // to an actual Employee Java object, if things go wrong there, theoretically we should never get here, so we don't
    // really need to provide the same validation we would on like the RoleService methods

    public Employee insertEmployee(Employee employee){
        return employeeDAO.insertEmployee(employee);
        // If you're thinking this'll just return the same employee object you passed it, you're mostly correct.
        // The main difference is that this should be an employee with a new value for its id since the database will
        // initialize that value

        // Update: Apparently I misread the DAO layer, disregard the above comment
    }
}
