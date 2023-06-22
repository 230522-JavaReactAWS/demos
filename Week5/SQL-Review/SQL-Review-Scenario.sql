-- Today you've been tasked with building a Relational Database for Ecommerce company you work for. They said that 
-- as their data analyst you should be able
-- to construct a series of tables that they can use to mark some of their orders.

-- Your first task is to create a series of tables. Starting with the customer first. The should have some unique identifier 
-- as well as some additional information like
-- name, email, and address etc. Build a table to store information for our customers adding any necessary constraints

CREATE TABLE customers(
	"customer_id" serial PRIMARY KEY,
	"name" varchar(50),
	email TEXT UNIQUE,
	address TEXT
);


-- Your next task is to construct a table for our products. This should include information about the product itself like 
-- name and price etc. Don't forget to have a unique
-- identifier.

CREATE TABLE products(
	product_id serial PRIMARY KEY,
	product_name TEXT NOT NULL,
	price decimal,
	inStock bool
);


-- After building these tables let's populate them with 5 entries each 

INSERT INTO customers ("name", email, address) VALUES 
('Daryl Fair', 'dfair@revature.com', '123 main street');

INSERT INTO customers ("name", email, address) VALUES 
('Joseph Onyenso', 'jo@email.com', '456 money blvd'),
('Bill Nye', 'nyerocks@yahoo.com', '5788 twerk ln'),
('Osey Ojez', 'ojez@gmail.com', '8207 font ln'),
('Bootie Well', '125up@gmail.com', '327 sugar ln');


INSERT INTO products (product_name, PRICE , INSTOCK) VALUES 
('PSP', 200.00, true),
('Steam Deck', 399.99, true),
('Overalls', 45.87, false),
('GI Joe', 500.00, false),
('Black Air Force Ones', 90, true);



-- Let's run some queries to make sure our information was accurately added to the database 

SELECT * FROM customers;

SELECT * FROM PRODUCTS;


-- Your boss wants a list of all the products he needs to procure before we can start selling them. Share with him a list 
-- of only the names of products he needs to get

SELECT PRODUCT_NAME FROM products WHERE INSTOCK = false;


-- It turns out your boss is unable to read names unless they're all caps, find a way to remedy the situation for him

SELECT upper(product_name) FROM products;

-- Round allows us to round decimals to certain points

SELECT product_name, round(price,0) FROM PRODUCTS P;


-- After we've done this, let's build an order table to decribe the contents of each order. First start by building a 
-- table that has generic information about an order like the id of the order itself, some way to mark the shipping 
-- address and some way to connect to the customer who placed the order 

CREATE TABLE orders(
	order_id serial PRIMARY KEY,
	shipping_address TEXT,
	customer_id_fk int REFERENCES customers(customer_id)
);


-- Now we need some way to connect the order table to the products themselves. Think about how we might desribe the 
-- relationship between orders and products before moving on

CREATE TABLE orders_products(
	order_id_fk int REFERENCES orders,
	product_id_fk int REFERENCES products
);



-- Awesome! Our schema should be done for now. Let's try adding in some orders now!

INSERT INTO orders (shipping_address, customer_id_fk) VALUES 
('123 main st', 1),
('456 example st', 3),
('456 example st', 3),
('789 money blvd', 4);

SELECT * FROM orders;


-- Let's connect some of these order with products
INSERT INTO ORDERS_PRODUCTS VALUES
(1, 1), (1, 4), (1, 5),
(2, 2), (2, 3),
(3, 5),
(4, 1), (4, 2);


-- After we're done placing orders, the boss comes to us with a problem. He says that users have no ability to update 
-- their information. He wants the to be able to update just about whatever they want (barring some unique identifier)
-- but none of the other analysts have been able to figure it out. Come up with a query we can run to update somebody's
-- information

UPDATE customers SET "name" = 'B Well', ADDRESS = '987 mo money st' WHERE CUSTOMER_ID = 5;
SELECT * FROM customers WHERE CUSTOMER_ID = 5;


-- You've been doing good for the company you're working at but now the boss wants you to come up with a way to delete 
-- orders that people want to cancel. Remember that there should be no remnants of this order in the system

DELETE FROM ORDERS_PRODUCTS WHERE ORDER_ID_FK = 4;

DELETE FROM orders WHERE ORDER_ID = 4;

-- Alter table to change constraint
ALTER TABLE orders_products DROP CONSTRAINT orders_products_order_id_fk_fkey;

ALTER TABLE orders_products ADD CONSTRAINT 
orders_products_order_id_fk_fkey FOREIGN KEY (order_id_fk) 
REFERENCES orders(order_id) ON DELETE CASCADE;

-- Let's add in a new order to test
INSERT INTO ORDERS (shipping_address, CUSTOMER_ID_FK) VALUES 
('1234 street blvd', 3);

SELECT * FROM orders;

INSERT INTO ORDERS_PRODUCTS VALUES 
(5, 1), (5,2), (5, 3);

DELETE FROM ORDERS WHERE ORDER_ID = 5;

DELETE FROM ORDERS_PRODUCTS WHERE ORDER_ID_FK = 5 AND PRODUCT_ID_FK = 2;


-- Now you've been tasked with coming up with queries that users can use when they search for a product. There are a 
-- couple of queries your boss wants you to implement:

-- Search the names of a product to see if it contains a word

SELECT * FROM PRODUCTS P WHERE PRODUCT_NAME ILIKE '%joe%';

-- Filter the products based on a specific price range
-- Let's say we have a price range of $250 minimum is 75
SELECT * FROM PRODUCTS P  WHERE price BETWEEN 75 AND 250;
SELECT * FROM PRODUCTS P WHERE price < 250 AND PRICE > 75 ORDER BY price;

-- Sort the products by price, low to high and high to low

SELECT * FROM PRODUCTS P ORDER BY price;
SELECT * FROM PRODUCTS P  ORDER BY PRICE DESC;

-- Your boss wants a speculation of how much money they could possibly make in a year. Come up with a wildly over 
-- optimistic number by claiming your going to sell 1,000,000 of your most expensive product. Write a query that 
-- will show this exact info

SELECT max(price) * 1000000 AS "projected_profits" FROM products;


-- Uh oh! Tax season has begun to roll around and your boss needs to know how much we've made in gross sales for the 
-- year, come up with a query that will allow us to find our total sales for every order in the books!

SELECT sum(price) FROM ORDERS_PRODUCTS OP 
JOIN PRODUCTS P ON PRODUCT_ID_FK = product_id;


-- Next, your boss wants you to help our other analysts write a report about which products are selling and how many 
-- we're selling. Come up with a query that shows the name of each product and how many sales we've had for that product

SELECT * FROM ORDERS_PRODUCTS OP 
JOIN PRODUCTS P ON PRODUCT_ID_FK = product_id
;


SELECT product_name, count(product_name) FROM ORDERS_PRODUCTS OP 
JOIN PRODUCTS P ON PRODUCT_ID_FK = product_id 
GROUP BY product_name;



-- Added in some sample orders (We're gonna do some off screen mining)
-- Put in 1000 more orders with 4000 products amongst them



-- Uh oh! Your boss is being kinda shady about how he wants to report this information to the investors since you gave him 
-- that overly optimistic number early. Give him a query that will show sales by product, but only show the products 
-- that have more than 900 sales. 



SELECT product_name, count(product_name) FROM ORDERS_PRODUCTS OP 
JOIN PRODUCTS P  ON OP.PRODUCT_ID_FK = P.product_id
GROUP BY product_name
HAVING count(product_name) > 1000;



-- People want to know how many of each product they've bought at the end of the year like some shopping spree version of a 
-- spotify wrapped. Find a way to show each person's name, the products they've bought, and how much of them. It should be 
-- ordered alphabetically by name and then by product count descending

SELECT C."name", P.PRODUCT_NAME, count(P.PRODUCT_NAME) FROM CUSTOMERS C 
JOIN ORDERS O ON O.CUSTOMER_ID_FK = C.CUSTOMER_ID
JOIN ORDERS_PRODUCTS OP ON OP.ORDER_ID_FK = O.ORDER_ID
JOIN PRODUCTS P ON OP.PRODUCT_ID_FK = P.PRODUCT_ID
GROUP BY C."name", P.PRODUCT_NAME
ORDER BY C."name", count(P.PRODUCT_NAME) DESC;




