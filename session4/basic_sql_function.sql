use quanlysinhvien;
select
	subid
    ,subname
    ,credit
    ,status
from subject
where credit in 
	(select
		max(credit)
	from subject
	);
select
	subid
    ,subname
    ,credit
    ,status
from subject
where subid in 
	(select
		subid
    from mark
    where mark in 
		(select
			max(mark)
		from mark
        )
    );

select
	s.*
    ,avg(mark) as average_mark
from mark m
join student s
on m.studentid = s.studentid
group by s.studentid;