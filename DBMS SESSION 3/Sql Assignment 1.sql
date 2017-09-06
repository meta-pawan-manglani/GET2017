/******************************
** File: DBMS Session3 Assignment1   
** Auth: Pawan Manglani
** Date: 5-Aug-2017
******************************/

/*use database lis*/
use lis;

/*this query will display the information of all the books issued these are sorted in ascending order of issue date and if 
 issue date of two or more entries are same than the data will be sorted by member name*/
SELECT m.member_nm AS MemberName,b.member_id AS MemberId,t.title_nm AS TitleName,
b.accession_no AS AccessionNo,b.issue_dt AS IssueDate,b.due_dt AS DueDate,
IFNULL(r.return_dt,'Not Returned') AS ReturnDate,TIMESTAMPDIFF(DAY,b.issue_dt,r.return_dt) AS time
FROM book_issue b 
/*join on table book and book_return*/
left join book_return r on b.accession_no = r.accession_no and b.member_id = r.member_id
/*join on table book and members*/
left join members m on b.member_id = m.member_id
/*joining books using accession no*/
join books book on b.accession_no = book.accession_no
/*joining titles using title id*/
join titles t on book.title_id = t.title_id
/*adding a condition which checks if time is more than 2 months or not*/
where TIMESTAMPDIFF(DAY,b.issue_dt,r.return_dt) >= 60
/*sort the result according to issue date and member name*/
ORDER BY m.member_nm,t.title_nm;

/*This query giving name of those mebers whose name length is maximum among all members*/
SELECT member_nm AS NAME, member_id ,length(member_nm) FROM members
/*codition which filter the result according to the length of name*/
WHERE length(member_nm) = (SELECT Max(length(member_nm)) FROM members);

/*This query display number of books issued so far*/
SELECT count(issue_dt) AS issuedBooks from book_issue; 

