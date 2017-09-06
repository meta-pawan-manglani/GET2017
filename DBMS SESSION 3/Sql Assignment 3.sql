/******************************
** File: DBMS Session3 Assignment3  
** Auth: Pawan Manglani
** Date: 5-Aug-2017
******************************/

/*use database lis*/
use lis;

/*
INSERT INTO `lis`.`members` (`member_id`, `member_nm`, `addressline1`, `addressline2`, `category`) VALUES (8, 'pawan13', 'Sector-15', 'Pratap Nagar', 'S');
INSERT INTO `lis`.`members` (`member_id`, `member_nm`, `addressline1`, `addressline2`, `category`) VALUES (9, 'pawan14', 'Sector-16', 'Pratap Nagar', 'S');
INSERT INTO `lis`.`members` (`member_id`, `member_nm`, `addressline1`, `addressline2`, `category`) VALUES (10, 'pawan15', 'Sector-17', 'Pratap Nagar', 'S');
INSERT INTO `lis`.`members` (`member_id`, `member_nm`, `addressline1`, `addressline2`, `category`) VALUES (11, 'pawan16', 'Sector-18', 'Pratap Nagar', 'S');
*/

/*This query display total number of students,total number of faculty and others in different different row*/
SELECT COUNT(category) as total_number,category FROM members 
/*Grouping the result on category*/
GROUP BY category NOT IN ('F','S')  , category IN ('S'), category in ('F');


/*This query display total number of students,total number of faculty and others in single row*/
SELECT COUNT(IF(category="S",1,NULL)) AS Student_count , COUNT(IF(category="F",1,NULL)) AS Faculty_count , 
/*counting the result according to category*/
COUNT(IF(category!="F" AND category!="S",1,NULL)) AS OTHERS
FROM members;


/*This query display the information of books which have been issued more than 2 times*/
SELECT t.title_nm , t.title_id FROM book_issue bi
/*joining table books and book_issue*/
JOIN books b ON bi.accession_no = b.accession_no
/*joining table titles and books*/
JOIN titles t on b.title_id = t.title_id
/*Grouping the result on accession_no where accession_no count should be greater than 1*/
GROUP BY bi.accession_no HAVING COUNT(bi.accession_no) > 1 ;


/*This query displays information of books that are issued to members of category other than F*/
SELECT m.member_nm,m.member_id FROM members m
/*joining table book_issue and members*/
JOIN book_issue b ON m.member_id = b.member_id
/*Gving condition category should not be F it filters the join operation result */
WHERE category not in ('F');


/*This query displays the information of those author for which at least 1 book has been purchased*/
SELECT author_nm,a.author_id FROM authors a
/*joining title_author table and authors table*/
JOIN title_author t ON a.author_id = t.author_id
/*joining title_author table and books table*/
JOIN books b ON t.title_id = b.title_id
/*Condition to filter the data It gives the data where purchase date exists*/
WHERE  EXISTS (SELECT b.purchase_dt FROM books WHERE t.title_id = b.title_id);