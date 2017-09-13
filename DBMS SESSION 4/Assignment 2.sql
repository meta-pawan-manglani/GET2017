/******************************
** File: DBMS Session4 Assignment2  
** Auth: Pawan Manglani
** Date: 7-Aug-2017
******************************/

/*use database lis*/
USE lis;

/*This command will drop view of issued books if exists*/
DROP VIEW IF EXISTS IssuedBooks;
/*This command will create view for details of issued books*/
CREATE VIEW IssuedBooks
AS
/*making of view*/
SELECT mb.member_nm,i.member_id,i.accession_no,i.issue_dt,i.due_dt FROM book_issue i
/*joining table books and memebers*/
JOIN members mb ON i.member_id = mb.member_id;
/*This command will display the view issuedBooks*/
SELECT member_nm,member_id,accession_no,issue_dt,due_dt
FROM IssuedBooks;

/*This command will drop view of MemberDetails if exists*/
DROP VIEW IF EXISTS MemberDetails;
/*This command will create view for details of members of a particular category*/
CREATE VIEW MemberDetails
AS
/*making of view*/
SELECT member_nm,member_id,IF(category='S','Student',IF(category='F','Faculty','Others')) AS Category
FROM members;
/*This query will display the view members*/
SELECT member_nm,member_id FROM MemberDetails;

/*This command will drop view of BookDetails if exists*/
DROP VIEW IF EXISTS BookDetails;
/*This command will create view for book details*/
CREATE VIEW BookDetails
AS 
/*making of view selecting column which has to be displayed in view*/
SELECT mb.member_nm,s.subject_nm,t.title_nm,mb.category,i.issue_dt,i.due_dt,r.return_dt FROM book_issue i 
/*joining table book_return and book_issue*/
LEFT JOIN book_return r ON i.accession_no = r.accession_no AND i.member_id = r.member_id
/*joining table book_issue and books*/
JOIN books b ON i.accession_no = b.accession_no
/*joining table titles and books*/
JOIN titles t ON b.title_id = t.title_id 
/*joining table subjects and titles*/
JOIN subjects s ON t.subject_id = s.subject_id,
members mb
WHERE mb.member_id = i.member_id;
/*This query will display the view BookDetails*/
SELECT member_nm,subject_nm,title_nm,category,issue_dt,due_dt,return_dt
FROM BookDetails;
