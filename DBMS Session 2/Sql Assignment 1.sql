/******************************
** File: DBMS Session2 Assignment1    
** Auth: Pawan Manglani
** Date: 4-Aug-2017
******************************/

/*specifying the databse which has to use*/
use lis;

/*this query will return all colums and rows of table members*/
select member_id,member_nm,addressLine1,addressLine2,category from members;

/*this query will return all the rows of member_nm,member_id,category colums of table members*/
select member_nm,member_id,category from members;

/*this query will return the rows of member_nm,member_id,category colums where category is F*/
select member_nm,member_id,category from members
where category = "F";

/*this query will return the different different category of table members*/
select Distinct(category) from members;

/*this query will return the member name and his category of table members sorted by mamber name in descending order*/
select member_nm,category from members
order by member_nm DESC;


/*this query will return all the titles their subject and publisher*/
select t.title_nm ,p.publisher_nm,s.subject_nm from titles  t
join subjects s on t.subject_id = s.subject_id 
join publisher p on t.publisher_id = p.publisher_id;


/*this query will count the total number of member present in each category*/
SELECT category,COUNT(*) AS `total` FROM members GROUP BY category;

/*this query will represent name of all the member who belong to the category as to which pawan belongs*/
SELECT m.* from members m join members e on m.category = e.category and e.member_nm = "pawan" and m.member_nm NOT IN ("pawan");

/*this query will display the information of all the books issued*/
SELECT b.issue_dt as IssueDate,b.accession_no as AccessionNo,b.member_id as MemberId,IFNULL(r.return_dt,'Not Returned') as ReturnDate 
from book_issue b  
/*join on table book and book return*/
left join book_return r on b.accession_no = r.accession_no;
