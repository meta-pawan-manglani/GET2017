/******************************
** File: DBMS Session2 Assignment4  
** Auth: Pawan Manglani
** Date: 4-Aug-2017
******************************/
/*If database is already exists than drop it*/
drop database if exists address;

/*create database address*/
create database address;

/*use it*/
use address;

/*create a table zipcode*/
/*this table contain infomation about pincode it's city_name in which the area exist and state associated to city*/
CREATE TABLE zipcode (
 /*column pincode contain pincode of area*/
  pincode int NOT NULL,
  /*column city_name contain name of city*/
  city_name varchar(40) NOT NULL,
  /*column state_name contain name of state*/
  state_name varchar(40) NOT NULL,
  /*pincode is the primary key of table*/
  PRIMARY KEY(pincode)
);

/*loading data  from a file named 'pincode_data.csv' to the table zipcode*/
LOAD DATA LOCAL INFILE 'C:/Users/User22/Desktop/Sql Session 2/pincode_data.csv' INTO TABLE address.zipcode FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n';

/*this query display all the fields where zipcode matches to the given input*/
select *  from zipcode
where pincode = 302020;