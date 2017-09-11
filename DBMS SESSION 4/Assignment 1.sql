/******************************
** File: DBMS Session4 Assignment1  
** Auth: Pawan Manglani
** Date: 7-Aug-2017
******************************/

/*use database lis*/
USE lis;

/*This query will display members of a particular category*/
SELECT member_nm FROM members 
/*Filter condition that filter the members on the basis of there category*/
WHERE category = (SELECT category 
                    FROM members WHERE member_nm = 'pawan13');

/*This query will display the information of issued books*/
SELECT bi.issue_dt,bi.due_dt,mb.member_nm,t.title_nm FROM book_issue bi 
/*joining book_return table and book_issue table*/
JOIN book_return r ON r.return_dt IS NULL AND bi.accession_no = r.accession_no AND bi.member_id = r.member_id,
books b 
/*joining titles table and books table*/
JOIN titles t ON b.title_id = t.title_id,
members mb 
/*filter condition it takes the data from book_return table*/
WHERE EXISTS (SELECT mb.member_nm FROM members WHERE r.member_id = mb.member_id );  

/* This query will display the information of books which are not returned on time*/
SELECT i.issue_dt,i.due_dt,r.return_dt,mb.member_nm,t.title_nm
FROM book_issue i
/*joining table book_issue and book_return*/
JOIN book_return r ON i.accession_no = r.accession_no AND i.member_id = r.member_id,
/*joining table books and titles*/
books b JOIN titles t ON b.title_id = t.title_id,
members mb 
WHERE DATEDIFF(r.return_dt,i.due_dt) >=1 AND  EXISTS (SELECT mb.member_nm FROM members WHERE r.member_id = mb.member_id );


/* This query will display the title of books which has price equivalent to highest price*/
SELECT b.title_id,t.title_nm,b.price,b.accession_no FROM books b
/*joining table books and title*/
JOIN titles t ON b.title_id = t.title_id
/*filter condition gives the name of books where price is highest among all the books*/
WHERE b.price = ( SELECT MAX(price) FROM books WHERE purchase_dt IS NOT NULL);

/* This query will display book which have second highest price*/
SELECT MAX(price)AS SecondMaximum,title_id FROM books
/*filter condition which select the price which has price lower than highest price*/
WHERE price < (SELECT MAX(price) FROM BOOKS);


describe books
