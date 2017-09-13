/******************************
** File: DBMS Session4 Assignment1  
** Auth: Pawan Manglani
** dt: 7-Aug-2017
******************************/

/*use database lis*/
USE lis;

/*This query will display members of a particular category*/
SELECT member_nm FROM members 
/*Filter condition that filter the members on the basis of there category*/
WHERE category = (SELECT category 
                    FROM members WHERE member_nm = 'pawan13');

/* This query will display the information of books which are not returned on time*/
SELECT issue_dt,titles.title_nm AS 'Title',members.member_nm AS 'Member name', due_dt AS 'Due dt'
FROM book_issue bi 
/*joining members table and book_issue table*/
JOIN members ON bi.member_id = members.member_id
/*joining titles table and books table*/
JOIN titles ON titles.title_id = (SELECT title_id FROM books WHERE bi.accession_no = books.accession_no)
/*filter condition it takes the data from book_return table*/
WHERE EXISTS (SELECT br.accession_no, br.member_id 
                      FROM book_return br
                      WHERE br.member_id = bi.member_id AND br.accession_no = bi.accession_no and br.return_dt Is NULL);  

/*Case 2 when some entries are not in book return table*/
SELECT bi.issue_dt AS 'Issue date',titles.title_nm AS 'Title',members.member_nm AS 'Member name', due_dt  AS 'Due date'
FROM book_issue bi 
/*joining table members and book_issue*/
LEFT JOIN members ON bi.member_id = members.member_id
/*joining table books and titles*/
LEFT JOIN titles ON titles.title_id = (SELECT books.title_id FROM books WHERE books.accession_no = bi.accession_no)
/*filter condition it takes the data from book_return table*/
 WHERE EXISTS (SELECT br.accession_no, br.member_id 
                      FROM book_return br
                      WHERE br.member_id = bi.member_id AND br.accession_no = bi.accession_no and br.return_dt Is NULL); 
   
/*case 3 when a entry is done in book return table only when book is returned*/
   SELECT issue_dt,titles.title_nm AS 'Title',members.member_nm AS 'Member name', due_dt AS 'Due date'
   FROM book_issue bi 
   JOIN members ON bi.member_id = members.member_id
   JOIN titles ON titles.title_id = (SELECT title_id FROM books WHERE bi.accession_no = books.accession_no) 
   WHERE NOT EXISTS (SELECT br.accession_no, br.member_id 
                       FROM book_return br
                       WHERE br.member_id = bi.member_id AND br.accession_no = bi.accession_no)
                       GROUP BY (bi.member_id);

/*This query will display the information of books which are returned after due date*/
SELECT bi.issue_dt AS 'Issue date',titles.title_nm AS 'Title',members.member_nm AS 'Member name', due_dt  AS 'Due date'
FROM book_issue bi 
/*joining table members and book_issue*/
JOIN members ON bi.member_id = members.member_id
/*joining table books and titles*/
JOIN titles ON titles.title_id = (SELECT books.title_id FROM books WHERE books.accession_no = bi.accession_no)
/*filter condition it takes the data from book_return table*/
 WHERE EXISTS (SELECT br.accession_no, br.member_id 
                   FROM book_return br 
                   WHERE DATEDIFF(br.return_dt,bi.due_dt) >=1 AND bi.member_id = br.member_id AND bi.accession_no = br.accession_no); 
                    
                       
                       
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
