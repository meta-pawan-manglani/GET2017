/******************************
** File: DBMS Session2 Assignment2   
** Auth: Pawan Manglani
** Date: 4-Aug-2017
******************************/

/*specifying the databse which has to use*/
use lis;


/*this query will display the information of all the books issued these are sorted in ascending order of issue date and if 
 issue date of two or more entries are same than the data will be sorted by member name*/
SELECT b.issue_dt as IssueDate,b.accession_no as AccessionNo,b.member_id as MemberId,m.member_nm as MemberName,
IFNULL(r.return_dt,'Not Returned') as ReturnDate 
from book_issue b 
/*join on table book and book_return*/
left join book_return r on b.accession_no = r.accession_no and b.member_id = r.member_id
/*join on table book and members*/
left join members m on b.member_id = m.member_id
/*sort the result according to issue date and member name*/
ORDER BY b.issue_dt,m.member_nm;