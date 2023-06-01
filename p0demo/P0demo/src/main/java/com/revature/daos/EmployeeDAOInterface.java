package com.revature.daos;

import com.revature.models.Employee;

import java.util.ArrayList;

//Remember, the main reason I like Interfaces is for organization and clarity
//DAO methods are long. Imagine we have 20 DAO methods. An Interface is a quick way to see what methods we have.
public interface EmployeeDAOInterface {

    //below are some abstract methods that EmployeeDAO will implement

    //A method to SELECT all employees
    ArrayList<Employee> getAllEmployees();
    /*Why an ArrayList? Get all will return multiple employees
      So we need some kind of COLLECTION that can store multiple Employee objects*/

    //A method to INSERT a new employee
    Employee insertEmployee(Employee emp);
    //This returns an Employee so the user can see the data they entered as confirmation

    //A method to DELETE an employee (SELF STUDY PRACTICE, Friday or Monday)


}
