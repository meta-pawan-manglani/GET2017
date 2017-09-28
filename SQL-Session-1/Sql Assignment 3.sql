/******************************
** File: SQL Assignment3    
** Auth: Pawan Manglani
** Date: 3-Aug-2017
******************************/

/* inserting values into table members*/
insert into members(member_nm,addressline1,addressline2,category) values ("shubham","csan","bhl","F");
insert into members(member_nm,addressline1,addressline2,category) values ("udit","csk","ajmer","G");
insert into members(member_nm,addressline1,addressline2,category) values ("pawan","kirti nagar","jpr","F");
insert into members(member_nm,addressline1,addressline2,category) values ("jain","tonk road","jaipr","G");
insert into members(member_nm, addressline1, addressline2, category) values("Rajat", "Sector-6", "Sanganer", "F");
insert into members(member_nm, addressline1, addressline2, category) values( "Raja", "Sector-13", "Pratap Nagar", "G");
insert into members(member_nm, addressline1, addressline2, category) values( "gaurav", "Sector-14", "Pratap Nagar", "F");

/* inserting values into table subjects*/
insert into subjects(subject_nm) values ("Chemistry");
insert into subjects(subject_nm) values ("Physics");
insert into subjects(subject_nm) values ("Computer");
insert into subjects(subject_nm) values ("Science");
insert into subjects(subject_nm) values ("C++ Programming");
insert into subjects(subject_nm) values("Oracle");
insert into subjects(subject_nm) values("JavaScript");
insert into subjects(subject_nm) values("JAVA");


/* inserting values into table publisher*/
insert into publisher(publisher_nm) values ("K.K. Menon");
insert into publisher(publisher_nm) values ("Sachin");
insert into publisher(publisher_nm) values ("TMH");
insert into publisher(publisher_nm) values ("Tata");
insert into publisher(publisher_nm) values("Arihant Publications");
insert into publisher(publisher_nm) values("Taxmann Publications");
insert into publisher(publisher_nm) values("Genius Publications");


/* inserting values into table authors*/
insert into authors(author_nm) values ("Arjun P.");
insert into authors(author_nm) values ("Prakash");
insert into authors(author_nm) values ("Herbert schildt");
insert into authors(author_nm) values ("E.Balaguruswami");
insert into authors(author_nm) values("James Gosling");
insert into authors(author_nm) values("Danielle Steel");
insert into authors(author_nm) values("William Shakespeare");


/* inserting values into table titles*/
insert into titles(title_nm,subject_id,publisher_id) values ("Organic Fundamentals","1","1");
insert into titles(title_nm,subject_id,publisher_id) values ("HC Verma","2","2");
insert into titles(title_nm,subject_id,publisher_id) values ("Programming Fundamentals Java","3","3");
insert into titles(title_nm,subject_id,publisher_id) values ("Programming Fundamentals C++","4","4");
insert into titles(title_nm, subject_id,publisher_id) values("Earth Facts",  "5", "5");
insert into titles(title_nm, subject_id,publisher_id) values("Know Database Management", "6", "6");
insert into titles(title_nm, subject_id,publisher_id) values("JAVA - Basics", "7", "7");


/* inserting values into table books*/
insert into books(title_id,purchase_dt,price,status) values ("1",now(),"125.00","not avilable");
insert into books(title_id,price,status) values ("2","132.00","available");
insert into books(title_id,price,status) values ("3","125.00","not avilable");
insert into books(title_id,price,status) values ("4","132.00","available");
insert into books(title_id,price, status) values("5","215.00", "available");
insert into books(title_id,price, status) values("6","510.00", "available");
insert into books(title_id,price, status) values("7","220.00", "available");


/* inserting values into table title_author*/
insert into title_author(title_id,author_id) values ("1","1");
insert into title_author(title_id,author_id) values ("2","2");
insert into title_author(title_id, author_id) values("3", "3");
insert into title_author(title_id, author_id) values("4", "4");
insert into title_author(title_id, author_id) values("5", "5");
insert into title_author(title_id,author_id) values ("6","6");
insert into title_author(title_id,author_id) values ("7","7");

/* inserting values into table book_issue*/
insert into book_issue(accession_no,member_id) values ("1","1"); 
insert into book_issue(accession_no,member_id) values ("2","2");
insert into book_issue(accession_no,member_id) values ("3","3");
insert into book_issue(accession_no,member_id) values ("4","4");
insert into book_issue(accession_no,member_id) values ("5","5");
insert into book_issue(accession_no,member_id) values ("6","6");
insert into book_issue(accession_no,member_id) values ("7","7");


/*inserting into book_return by taking data from book issue table*/
insert into book_return(return_dt,accession_no,member_id, issue_dt) SELECT now(),accession_no, member_id, issue_dt FROM book_issue where member_id = '1' and accession_no = '1';
insert into book_return(return_dt,accession_no,member_id, issue_dt) SELECT now(),accession_no, member_id, issue_dt FROM book_issue where member_id = '2' and accession_no = '2';
insert into book_return(return_dt,accession_no,member_id, issue_dt) SELECT now(),accession_no, member_id, issue_dt FROM book_issue where member_id = '3' and accession_no = '3';
insert into book_return(return_dt,accession_no,member_id, issue_dt) SELECT now(),accession_no, member_id, issue_dt FROM book_issue where member_id = '4' and accession_no = '4';
insert into book_return(return_dt,accession_no,member_id, issue_dt) SELECT now(),accession_no, member_id, issue_dt FROM book_issue where member_id = '5' and accession_no = '5';
insert into book_return(accession_no,member_id, issue_dt) SELECT accession_no, member_id, issue_dt FROM book_issue where member_id = '6' and accession_no = '6';
insert into book_return(accession_no,member_id, issue_dt) SELECT accession_no, member_id, issue_dt FROM book_issue where member_id = '7' and accession_no = '7';


/*updating members table where category is 'F' or 'G'*/
UPDATE members 
SET addressline2 = "jaipur"
where category = "F" or "G";

/*updating addressLine1 of members table where category is 'F'*/
UPDATE members SET addressline1 = "EPIP, Sitapura" where category="F";

/*Deleting all row of publisher*/
DELETE FROM PUBLISHER;


/*Set into publisher table using substitution variable*/
SET @publisher_id1 = 1;
SET @publisher_nm1 = 'McGraw Hill';
SET @publisher_id2 = 2;
SET @publisher_nm2 = 'Corman';
INSERT INTO publisher(publisher_id, publisher_nm) VALUES (@publisher_id1, @publisher_nm1), (@publisher_id2, @publisher_nm2);

/*deleting record of publisher table where id = 1*/
DELETE FROM titles where publisher_id ="1";

