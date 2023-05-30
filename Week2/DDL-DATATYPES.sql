--To create a new schema (which we'll do for every individual database/demo/project):
--right click the schemas folder -> create new schema -> give it a name
--right click the new schema -> sql editor -> new sql script

--Data Definition Language (DDL): CREATE, ALTER, TRUNCATE, DROP 
--DDL is any SQL command that relates to the STRUCTURE of your database and its tables.

--the CREATE command lets us create database tables
CREATE TABLE users(
	username TEXT 
	--username is the name of a column (attribute) in the users table
	--TEXT is the datatype. So usernames will be stored in text format. (Like a Java String)
);

--we can view this table by right clicking the schema -> view diagram
--don't forget to right click -> refresh the schema for changes to populate

--OH NO!! I forgot to add the user's age to the table! I can ALTER the table with the ALTER command
ALTER TABLE users ADD user_age int;

--I won't run the two commands below (there's no data and I want the table to stay up)

--we can use TRUNCATE to wipe all the data from a table
TRUNCATE TABLE users;

--we can use DROP to delete a table and and all of its data
DROP TABLE users;




