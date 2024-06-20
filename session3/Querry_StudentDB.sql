select
	*
from student
where lcase(studentname) like "h%";

select 
*
from class
where month(startdate) = 12;

select
*
from subject
where credit between 3 and 5;

update student set classid = 2 where name = "Hung";

select
	studentname
    ,subname
    ,mark
from mark m
join student s
on m.studentid = s.studentid
join subject sub
on m.subid = sub.subid
order by mark desc, studentname;