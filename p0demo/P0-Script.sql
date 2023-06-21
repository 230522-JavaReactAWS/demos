--roles table
CREATE TABLE roles(

    role_id serial PRIMARY KEY, --The primary key UNIQUELY IDENTIFIES each record (row) in a table 
    --serial is an auto-incrementing int data type - perfect primary keys, which must be unique
    --whenever we insert a new record, the primary key will get populated and incremented for us
    role_title TEXT UNIQUE, --now, every role must have a different title from each other
    role_salary int check(role_salary > 20000) --thanks to the check constraint, salaries cannot be less than 20000. 

);


--employees table
CREATE TABLE employees(

    employee_id serial PRIMARY KEY, --same as above. unique identifier that automatically increments
    first_name TEXT NOT NULL, --every employee must have a first name (NOT NULL)
    last_name TEXT NOT NULL,
    role_id_fk int REFERENCES roles(role_id) --this is a FOREIGN KEY. (note the "references" keyword)
    /* this is saying "every employee has a role." This forieng key point to the primary key in the roles table
         THIS IS HOW WE ESTABLISH RELATIONSHIPS BETWEEN TABLES
         Now, every employee must have a role, and a role can have one, many, or no employees related to it*/

);

INSERT INTO roles(role_title, role_salary)
VALUES ('Manager', 100000), 
       ('Cashier', 40000), 
       ('Fry Cook', 50000), 
       ('Marketing Director', 100000);

--we can use SELECT to view data in the table
SELECT * FROM roles; -- * means "everything". we're saying "select everything from the roles table"


INSERT INTO employees(first_name, last_name, role_id_fk)
VALUES ('Eugene', 'Krabs', 1),
       ('Spongebob', 'Squarepants', 3),
       ('Squidward', 'Tentacles', 2),
       ('Sheldon', 'Plankton', 1);


SELECT * FROM employees;




