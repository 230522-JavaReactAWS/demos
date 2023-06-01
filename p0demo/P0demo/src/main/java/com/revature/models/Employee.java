package com.revature.models;

public class Employee {

    private int employee_id;
    private String first_name;
    private String last_name;

    /*Employee objects in Java will contain entire Role objects instead of just an int foreign key (FK)
     an int FK is less useful to us than an entire Role object. Role objects have all the data relevant to Role.*/
    private Role role;

    /*We have this variable to make inserts easier (when we insert a new Employee)
     When inserting a new Employee, we can just include the FK (the int) instead of an entire Role object*/
    private int role_id_fk;

    //we'll have different constructors using one or the other foreign key variable, used for different purposes

    //boilerplate code--------------------------

    //no args
    public Employee() {
    }

    //all args (with Role object)
    public Employee(int employee_id, String first_name, String last_name, Role role) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
    }

    //all args minus id (with Role object)
    public Employee(String first_name, String last_name, Role role) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
    }

    //all args minus id (with role_id_fk int) ***THIS WILL ONLY BE USED FOR INSERTS
    public Employee(String first_name, String last_name, int role_id_fk) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.role_id_fk = role_id_fk;
    }

    

}
