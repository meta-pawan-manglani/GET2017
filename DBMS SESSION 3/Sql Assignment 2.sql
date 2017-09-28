/******************************
** File: DBMS Session3 Assignment2  
** Auth: Pawan Manglani
** Date: 5-Aug-2017
******************************/

/*use database lis*/
use lis;

/*This command will give information of number of books purchased*/
SELECT s.subject_nm,s.subject_id,count(t.title_id) AS TOTALBOOKSPURCHASED FROM subjects s
/*joining table title and subjects*/
JOIN titles t ON t.subject_id =  s.subject_id
/*grouping the result using subject_id*/
group by(s.subject_id);



/*this query will display the information of all the books issued these are sorted in ascending order of issue date and if 
 issue date of two or more entries are same than the data will be sorted by member name*/
SELECT m.member_nm AS MemberName,b.member_id AS MemberId,t.title_nm AS TitleName,
b.accession_no AS AccessionNo,b.issue_dt AS IssueDate,b.due_dt AS DueDate,
TIMESTAMPDIFF(DAY,b.issue_dt,b.due_dt) AS time
FROM book_issue b 
/*join on table book and members*/
JOIN members m ON b.member_id = m.member_id
/*joining books using accession no*/
JOIN books book ON b.accession_no = book.accession_no
/*joining titles using title id*/
JOIN titles t ON book.title_id = t.title_id
/*adding a condition which checks if time is more than 2 months or not*/
where TIMESTAMPDIFF(DAY,b.issue_dt,b.due_dt) >= 60
/*sort the result according to issue date and member name*/
ORDER BY m.member_nm,t.title_nm;



/*This command will give the title name of those books whose price are greater than lowest price*/
SELECT t.title_nm AS NAME,b.price AS PRICE FROM titles t
/*joining table books and titles*/
JOIN books b ON b.title_id =  t.title_id
/*condition it filter the result on price*/ 
WHERE b.price > (SELECT MIN(price) FROM books);
