
select
	e.employee_id
    ,name
    ,degree_name
    ,department_name
    ,phone_number
    ,address
from employees e
join degrees d
on e.degree_id = d.degree_id
join departments de
on e.department_id = de.department_id
join 
	(select 
		employee_id
		,count(contract_id) as number_contract
	from contracts
	where start_date between '2018-01-01' and '2019-12-31'
	group by 1
	having number_contract <= 3
	) temp
on e.employee_id = temp.employee_id