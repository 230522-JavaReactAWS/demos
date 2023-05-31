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

--DATA TYPES-------------------------------

--I'm going to make a horribly designed table to list out some data types
--Why is this table bad? No primary key, not normalized, bad column names, we'll never make another table like this

CREATE TABLE datatypes(

	small_number int2, --2 bytes. used for smaller numbers (like a short in Java)
	normal_number int, --4 bytes, most commonly used int type
	big_number int8, --8 bytes in size, normally used for very large numbers (like a long in Java)
	standard_decimal decimal(10, 2), --2 parameters (total # of digits, total # of decimal places)
	--So this decimal will be 8 integers and 2 decimal places
	
	"boolean" boolean, --double quotes let you use keywords etc. as column names
	
	fixed_length_text char(2), --TEXT field that can ONLY hold the amount of characters given (2 in this case)
	variable_length_text varchar(15), --TEXT field that can hold UP TO the amount of characters given
	unlimited_length_text TEXT, --unlimited length, I use this one primarily  
	
	"date" date --lets you input dates in YYYY-MM-DD format
	--can be tricky to convert from Java Date objects... sometimes I prefer just a text-based date in the db 
	
	--because no other columns come after the date column, we don't put a comma

);

--there are A LOT more datatypes. Feel free to look into them, but we'll mostly just use int, text, and maybe boolean.


