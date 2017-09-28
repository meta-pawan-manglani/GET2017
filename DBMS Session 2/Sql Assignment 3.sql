/******************************
** File: DBMS Session2 Assignment3  
** Auth: Pawan Manglani
** Date: 4-Aug-2017
******************************/

/*If database is already exists than drop it*/
DROP DATABASE  IF EXISTS ECommerce;

/*creating database for ecommerece*/
CREATE DATABASE ECommerce ;

/*using the database ecommerce*/
use ECommerce;

/*creating table categories containing categories of product their type and there parent category*/
CREATE TABLE  categories (
/*category column contain category of product*/
category int not null,
/*parent category contain information of parent category of product*/
parentcategory int , 
/*type of product*/
type varchar(50),
/*category is the primary key of table*/
PRIMARY KEY (category),
/*making foreign key parent category refrencing category column of table*/
CONSTRAINT parentcategory FOREIGN KEY (parentcategory) REFERENCES categories(category)
);

/*inseting values of category 'Mobile and Tablets' parent category 'Mobiles & Tablets'*/
insert into categories(category,type) values ("1","Mobiles & Tablets");
insert into categories(category,parentcategory,type) values ("2","1","Mobiles");
insert into categories(category,parentcategory,type) values ("3","1","Tablets");
insert into categories(category,parentcategory,type) values ("4","2","Smart Phones");
insert into categories(category,parentcategory,type) values ("5","2","Feature Phones");
insert into categories(category,parentcategory,type) values ("6","3","2G");
insert into categories(category,parentcategory,type) values ("7","3","3G");
insert into categories(category,parentcategory,type) values ("8","1","Accessories");
insert into categories(category,parentcategory,type) values ("9","1","Cases & Covers");

/*inseting values of category 'Computers' parent category 'Computers'*/
insert into categories(category,type) values ("10","Computers");
insert into categories(category,parentcategory,type) values ("11","10","Desktop");
insert into categories(category,parentcategory,type) values ("12","10","Laptop");
insert into categories(category,parentcategory,type) values ("13","10","Laptop Accessories");
insert into categories(category,parentcategory,type) values ("14","13","Keyboard");
insert into categories(category,parentcategory,type) values ("15","13","Mouse");
insert into categories(category,parentcategory,type) values ("16","13","Headphones");
insert into categories(category,parentcategory,type) values ("17","10","Printers");
insert into categories(category,parentcategory,type) values ("18","17","Inkjet");
insert into categories(category,parentcategory,type) values ("19","17","Laser");



/*inseting values of category 'Home Appliances' parent category 'Home Appliances'*/
insert into categories(category,type) values ("20","Home Appliances");
insert into categories(category,parentcategory,type) values ("21","20","TVs");
insert into categories(category,parentcategory,type) values ("22","21","LED");
insert into categories(category,parentcategory,type) values ("23","21","LCD");
insert into categories(category,parentcategory,type) values ("24","21","Plasma");
insert into categories(category,parentcategory,type) values ("25","20","Air Conditioners");
insert into categories(category,parentcategory,type) values ("26","20","Washing Machines");
insert into categories(category,parentcategory,type) values ("27","26","Full Automatic");
insert into categories(category,parentcategory,type) values ("28","27","Top Load");
insert into categories(category,parentcategory,type) values ("29","27","Front Load");
insert into categories(category,parentcategory,type) values ("30","26","Semi Automatic");


/*this query will display all the category along with the parent categories*/
SELECT category,type,parentcategory FROM categories Group BY parentcategory,category;


/*this query will display all the category along with the parent categories and result will be sorted according to parent category*/
SELECT category,parentcategory FROM categories ORDER BY parentcategory;

/*this query will display all the category and its parent category and result will be sorted according to parent category
in case if parent category is null it will field by Top Category*/
SELECT category,type ,IFNULL(parentcategory,"Top Category") AS ParentCategory FROM categories 
Group BY parentcategory,category ORDER BY parentcategory ;


/*this quey will display all the top category rows*/
SELECT category,type,IFNULL(parentcategory,"Top Category") AS ParentCategory FROM categories WHERE parentcategory IS NULL;