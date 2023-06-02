--This demo will demonstrate Normal Forms 1-3, and Joins (at the end)

/* 1st NORMAL FORM (we do not want this in our projects or ever)

	Rules:
	1) Tables must have a primary key (can be a composite key, a PK made up of multiple columns)
	2) Columns must be atomic (cells should only contain the smallest piece of data possible) 

*/

CREATE TABLE superheroes(

	hero_name TEXT,
	hero_power TEXT,
	first_name TEXT,
	last_name TEXT,
	home_base TEXT,
	street_address TEXT,
	PRIMARY KEY(hero_name, first_name) --this is a composite key (ugly and stinky) 
	--composite keys are made up of multiple columns to uniquely identify a record. This can cause lots of complexity
	
);

INSERT INTO superheroes (hero_name, hero_power, first_name, last_name, home_base, street_address)
VALUES ('Spiderman', 'Webby hand boi', 'Peter', 'Parker', 'His aunt''s house', '123 street st'),
	   ('Spiderman', 'Webby hand boi', 'Miles', 'Morales', 'His aunt''s house', '123 street st'),
	   ('Batman', 'he is rich and has toys', 'Bruce', 'Wayne', 'Wayne Manor', '456 road rd'),
	   ('One Punch Man', 'Bald and punches you... once', 'Saitama', 'Baldcapeman', 'His apartment', '789 avenue ave');
	   

SELECT * FROM superheroes;

DROP TABLE superheroes;
	  

/* 2ND NORMAL FORM (This is better, but we still want to achieve 3rd NF)
 
 To be in 2NF, we must remove partial dependencies (Only a single-column primary key is allowed
 So, this is a perfect reason to keep using the serial primary keys we've seen before! */
	  
CREATE TABLE superheroes(

	hero_id serial PRIMARY KEY, --Much better. No more composite keys!
	hero_name TEXT,
	hero_power TEXT,
	first_name TEXT,
	last_name TEXT,
	home_base TEXT,
	street_address TEXT
	
);

INSERT INTO superheroes (hero_name, hero_power, first_name, last_name, home_base, street_address)
VALUES ('Spiderman', 'Webby hand boi', 'Peter', 'Parker', 'His aunt''s house', '123 street st'),
	   ('Spiderman', 'Webby hand boi', 'Miles', 'Morales', 'His aunt''s house', '123 street st'),
	   ('Batman', 'he is rich and has toys', 'Bruce', 'Wayne', 'Wayne Manor', '456 road rd'),
	   ('One Punch Man', 'Bald and punches you... once', 'Saitama', 'Baldcapeman', 'His apartment', '789 avenue ave');
	  
SELECT * FROM superheroes;
	  
DROP TABLE superheroes;

/* 3RD NORMAL FORM - THIS IS WHAT WE WANT OUR TABLES TO BE!!!
  
   To be in 3rd NF, we must remove transitive dependencies (we need to split tables according to their topic/content)
   In other words, tables must have a SINGLE RESPONSIBILITY. One table deals with heros. One table deals with homes.*/

CREATE TABLE homes (

	home_id serial PRIMARY KEY,
	home_name TEXT,
	street_address TEXT --could have added stuff like city, state, zip in their own repective columns

);

CREATE TABLE superheroes(

	hero_id serial PRIMARY KEY, --Much better. No more composite keys!
	hero_name TEXT,
	hero_power TEXT,
	first_name TEXT,
	last_name TEXT,
	home_id_fk int REFERENCES homes(home_id) --foreign key creation 
	--thanks to the PK/FK relationship, every hero has a home, and a home can have 0 or multiple heros in it.
	
);

INSERT INTO homes (home_name, street_address)
VALUES ('His aunt''s house', '123 street st'), 
	   ('Wayne Manor', '456 road rd'), 
	   ('His apartment', '789 avenue ave'),
	   ('Ben''s House', '111 beach way');

SELECT * FROM homes;

INSERT INTO superheroes (hero_name, hero_power, first_name, last_name, home_id_fk)
VALUES ('Spiderman', 'Webby hand boi', 'Peter', 'Parker', 1),
	   ('Spiderman', 'Webby hand boi', 'Miles', 'Morales', 1),
	   ('Batman', 'he is rich and has toys', 'Bruce', 'Wayne', 2),
	   ('One Punch Man', 'Bald and punches you... once', 'Saitama', 'Baldcapeman', 3);
	  
SELECT * FROM superheroes;

--cool, we are fully in 3NF, which is what we typically want. 

--Note that the homes table does not depend on superheroes. Superheroes depend on homes
--We have a home with two heros related to it, one home (ben's house) has no heroes related to it
--The relation matter to heros, it doesn't matter as much to homes.


--JOINS-------------------------

--insert a superhero with no home
INSERT INTO superheroes (hero_name, hero_power, first_name, last_name, home_id_fk)
VALUES ('Hancock', 'Power Slap', 'Will', 'Smith', NULL);

--Remember, joins are necessary when we want to SELECT data from multiple tables. MULTI-TABLE QUERIES!!

--INNER JOIN
--return all records with matching data/results (typically from the PK/FK) in both tables
SELECT * FROM superheroes INNER JOIN homes ON home_id_fk = home_id;

--LEFT JOIN
--returns all records from the left table, and matching records on the right table
SELECT * FROM superheroes LEFT JOIN homes ON home_id_fk = home_id;

--RIGHT JOIN
--returns all records from the right table, and matching records on the left table
SELECT * FROM superheroes RIGHT JOIN homes ON home_id_fk = home_id;

--RIGHT VS LEFT? This is determined by the position of the table in the join SYNTAX
--LEFT_TABLE JOIN RIGHT_TABLE

--FULL JOIN (AKA FULL OUTER JOIN)
--return everything.
SELECT * FROM superheroes FULL JOIN homes ON home_id_fk = home_id;


