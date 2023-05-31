--I want to create two tables with a relationship
--I can accomplish this with primary keys and foreign keys
--Foreign keys of one table point to primary keys of another table. THIS ESTABLISHES A RELATIONSHIP

--This schema will track employees and their roles

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


--DML------------------------------

--Data Manipulation Language - SELECT, INSERT, UPDATE, DELETE (SELECT may also be considered DQL as opposed to DML)


/*INSERT some data into my tables
  
  we specify what table and columns we're filling with data 
  (we don't need to put a value for the auto-incrementing serial)
  and then, we specify what data we actually want to insert
  each pair of parenthesis will be a different record in the table */

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

--The WHERE CLAUSE-----------------------------

--The WHERE clause in a SELECT statement lets us further filter the data that comes back

--all roles where role_salary is 100,000 (=)
SELECT * FROM roles WHERE role_salary = 100000;

--all roles where role_salary is NOT 100,000 (!=)
SELECT * FROM roles WHERE role_salary != 100000;

--all roles where role_salary is less than 100,000 (<)
SELECT * FROM roles WHERE role_salary < 100000;

--all employees who have a first name starting with 'S' (LIKE %)
SELECT * FROM employees WHERE first_name LIKE 'S%';
--employees who's names start with S (and then the rest doesn't matter)

--all employees with a salary BETWEEN 30000 and 70000 (BETWEEN AND)
SELECT * FROM roles WHERE role_salary BETWEEN 30000 AND 70000;

--all employees names Eugene OR Sheldon (OR)
SELECT * FROM employees WHERE first_name = 'Eugene' OR first_name = 'Sheldon'; 

--the same as above, but with the IN operator
SELECT * FROM employees WHERE first_name IN ('Eugene', 'Sheldon'); --better if there are many values to choose from 


--ORDER BY-----------------------------

SELECT * FROM roles ORDER BY role_salary; --by default, it orders by increasing order

--we can specify "desc" for descending order
SELECT * FROM employees ORDER BY first_name DESC;


--FUNCTIONS----------------------------

--Scalar functions can take in up to one value, and they return one value
SELECT now(); --returns current date/time
SELECT upper('this string will be returned in uppercase');

--Aggregate functions can take multiple values, and they return one value
SELECT avg(role_salary) FROM roles;
SELECT sum(role_salary) FROM roles;
SELECT count(first_name) FROM employees;

--GROUP BY will merge rows together based on matching column values
SELECT count(*) FROM roles GROUP BY role_salary;

--HAVING is like a where clause, but it can only be used after a GROUP BY. WHERE will not work after a group by.
SELECT count(*) FROM employees GROUP BY last_name HAVING last_name = 'Tentacles';

--This is because the WHERE clause only works after a selection from the tables
--WHERE does NOT work on values returned from aggregate functions.


--UPDATE--------------------

--We can use the UPDATE command to change values in our tables

--lets say want to change an employees last name (maybe they got married or sumn)
UPDATE employees SET last_name = 'Plankton' WHERE first_name = 'Sheldon';
--NOTE: the where clause is important here, otherwise everybody's last name would change


--DELETE--------------------

--We can use delete to delete records from a table. (I don't often do this, but sometimes it's necessary)

--trying to delete the marketing director role
DELETE FROM roles WHERE role_title = 'Marketing Director';
--this DELETE works fine, since no employees are linked to the Marketing Director role

--now, let's try to delete the Manager role
DELETE FROM roles WHERE role_title = 'Manager';
--Can't do it! There are employee records that are pointing to the Manager records
--If you try to delete a record that is depended on by other records, PostgreSQL won't let you do it.

/* Why can't we delete??
 
  This is just a built-in rule, to avoid what's known as "orphan records"
  "We can't have records that refer to other records that don't exist"
  		This is one way SQL enforces REFERENTIAL INTEGRITY 
  		
  In order for this delete to work, we would have had to say "ON DELETE CASCADE" in our foreign key column
  observe below: (not a real table we'll use) */

CREATE TABLE employees(

	employee_id serial PRIMARY KEY, 
	first_name TEXT NOT NULL, 
	last_name TEXT NOT NULL,
	role_id_fk int REFERENCES roles(role_id) ON DELETE CASCADE --this also works for ON UPDATE CASCADE

);

--we could have also done ON DELETE SET NULL, if we want to preserve the record but not the FK