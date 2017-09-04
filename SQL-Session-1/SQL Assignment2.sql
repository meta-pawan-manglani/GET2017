/******************************
** File: SQL Assignment2    
** Auth: Pawan Manglani
** Date: 3-Aug-2017
******************************/
drop database if exists lis;

/*creating the database*/
CREATE DATABASE lis;

/*using the above created database*/
use  lis;

/*creating table members*/
/*This table contain master data of members of the library*/
CREATE TABLE members (
/*member_id store id of member*/
member_id int NOT NULL AUTO_INCREMENT,
/*member_nm store name of member*/
member_nm varchar(20),
/*addressLine 1 store the 1st line of address*/
addressline1 varchar(45),
/*addressLine 2 store the 2nd line of address*/
addressline2 varchar(45),
/*It store the category of member*/
category varchar(20),
/*member_id is the primary key of table members*/
PRIMARY KEY(member_id) 
);

/*creating table subjects*/
/*This table contain master data of subjects under which books are qualified*/
CREATE TABLE subjects (
/*subject id store id of subject*/
subject_id int NOT NULL AUTO_INCREMENT,
/*subject_nm store name of subject*/
subject_nm varchar(20),
/*subject_id is the primary key of subjects table*/
PRIMARY KEY(subject_id) 
);

/*creating table publisher*/
/*This table contain master data of publishers of the purchased book*/
CREATE TABLE publisher (
/*publisher id store id of publisher*/
publisher_id int NOT NULL AUTO_INCREMENT,
/*publisher_nm store name of publisher*/
publisher_nm varchar(20),
/*publisher_id is the primary key of publisher table*/
PRIMARY KEY(publisher_id) 
);

/*creating table authors*/
/*This table contain master data of authors whose books have been purchased*/
CREATE TABLE authors (
/*author_id store id of author*/
author_id int NOT NULL AUTO_INCREMENT,
/*author_nm store name of author*/
author_nm varchar(20),
/*author_id is the primary key of author table*/
PRIMARY KEY(author_id) 
);

/*creating table titles*/
/*This table contain master data of books titles*/
CREATE TABLE titles (
/*title_id store id of title*/
title_id int NOT NULL AUTO_INCREMENT,
/*title_nm store name of title*/
title_nm varchar(40),
/*subject_id store id of subject*/
subject_id int,
/*publisher_id store id of publisher*/
publisher_id int,
/*title_id is the primary key of titles table*/
PRIMARY KEY(title_id),
/*subject_id is the foreign key refrences to  subject_id column of subjects table*/
CONSTRAINT fk_titles_subject_id FOREIGN KEY (subject_id) REFERENCES subjects(subject_id) ON DELETE CASCADE ON UPDATE CASCADE,
/*publisher_id is the foreign key refrences to publisher_id column of publisher table*/
CONSTRAINT fk_titles_publisher_id FOREIGN KEY (publisher_id) REFERENCES publisher(publisher_id) ON DELETE CASCADE ON UPDATE CASCADE
);

/*creating table title_author*/
/*This table contain master data of relationship amongst books and authors*/
CREATE TABLE title_author (
/*title_id store id of title*/
title_id int,
/*author_id store id of author*/
author_id int,
/*primary key is a composition of title_id and author_id*/
PRIMARY KEY(title_id,author_id),
/*title_id is the foreign key refrences to title_id column of titles table*/
CONSTRAINT fk_title_author_title_id FOREIGN KEY (title_id) REFERENCES titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE,
/*author_id is the foreign key refrences to author_id column of authors table*/
CONSTRAINT fk_title_author_author_id FOREIGN KEY (author_id) REFERENCES authors(author_id) ON DELETE CASCADE ON UPDATE CASCADE
);

/*creating table books*/
/*This table contain master data of each book*/
CREATE TABLE books (
/*accession_no is a unique number associated to book*/
accession_no int NOT NULL AUTO_INCREMENT,
/*purchase_dt is the date of purchase*/
purchase_dt timestamp,
/*price of book*/
price double,
/*status wheather book is available or not*/
status varchar(20),
/*title id of book*/
title_id int,
/*accession_no is primary key of table*/
PRIMARY KEY(accession_no),
/*title_id is the foreign key refrences to title_id column of titles table*/
CONSTRAINT fk_books_title_id FOREIGN KEY (title_id) REFERENCES titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE
);


/*creating table book_issue*/
/*This table contain transaction data of book issued to members*/
CREATE TABLE book_issue (
/*accession_no is a unique number associated to book*/
accession_no int,
/*issue_dt is the date when book is issued to member*/
issue_dt timestamp,
/*member_id store id of member*/
member_id int,
/*due date is the date till which book has to be returned to the library*/
due_dt timestamp,
/*primary key is a composition of issue_dt accession_no and member_id*/
PRIMARY KEY(issue_dt,accession_no,member_id),
/*member_id is the foreign key refrences to member_id column of subjects table*/
CONSTRAINT fk_book_issue_member_id FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE,
/*accession_no is the foreign key refrences to accession_no column of books table*/
CONSTRAINT fk_book_issue_accession_no FOREIGN KEY(accession_no) REFERENCES books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE
);

/*creating table book_return*/
/*This table contain transaction data of book returned by members*/
CREATE TABLE book_return (
/*accession_no is a unique number associated to book*/
accession_no int,
/*member_id store id of member*/
member_id int,
/*return_dt is the date on which book is returned to the library*/
return_dt timestamp NULL ON UPDATE CURRENT_TIMESTAMP,
/*issue_dt is the date when book is issued to member*/
issue_dt timestamp,
/*primary key is a composition of accession_no and member_id*/
PRIMARY KEY(accession_no,member_id),
/*member_id is the foreign key refrences to member_id column of subjects table*/
CONSTRAINT fk_book_return_member_id FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE,
/*accession_no is the foreign key refrences to accession_no column of books table*/
CONSTRAINT fk_book_return_accession_no FOREIGN KEY(accession_no) REFERENCES books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE
);


/*showing all tables*/
show tables;

/*altering table book_issue set the default value of issue_dt*/
ALTER TABLE book_issue
MODIFY COLUMN issue_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

/*altering table book_issue set the default value of due_dt*/
DELIMITER $$
CREATE TRIGGER dt_15days
BEFORE INSERT ON `book_issue` FOR EACH ROW
BEGIN
 SET NEW.due_dt = now() + INTERVAL 15 DAY;
END;
$$
DELIMITER ;
/*ending of trigger*/

/*droping the foreign key named member_id*/
ALTER TABLE book_return DROP FOREIGN KEY fk_book_return_member_id;

/*droping the foreign key named member_id*/
ALTER TABLE book_issue DROP FOREIGN KEY fk_book_issue_member_id;


/*droping the tabe members*/
drop table members;


/*creating table members*/
CREATE TABLE members (
/*member_id store id of member*/
member_id int NOT NULL AUTO_INCREMENT,
/*member_nm store name of member*/
member_nm varchar(20),
/*addressLine 1 store the 1st line of address*/
addressline1 varchar(45),
/*addressLine 2 store the 2nd line of address*/
addressline2 varchar(45),
/*It store the category of member*/
category varchar(20),
/*member_id is the primary key of table members*/
PRIMARY KEY(member_id) 
);

/*alter table book_return adding the foreign key member_id refrences member_id of members table*/
ALTER TABLE book_return ADD CONSTRAINT fk_book_return_member_id FOREIGN KEY(member_id) references members(member_id) ON DELETE CASCADE ON UPDATE CASCADE;
/*alter table book_issue adding the foreign key member_id refrences member_id of members table*/
ALTER TABLE book_issue ADD CONSTRAINT fk_book_issue_member FOREIGN KEY(member_id) references members(member_id) ON DELETE CASCADE ON UPDATE CASCADE;
