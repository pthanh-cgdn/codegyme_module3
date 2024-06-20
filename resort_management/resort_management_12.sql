

select 
	c.contract_id
    ,e.name as employee_name
    ,cus.name as customer_name
    ,cus.phone_number as customer_phone_number
    ,service_name
    ,deposit
    ,count(additional_service_id) as number_additional_services
from contracts c
join employees e
on c.employee_id = e.employee_id
join customers cus
on c.customer_id = cus.customer_id
join main_services s
on c.service_id = s.service_id
left join contract_details de
on c.contract_id = de.contract_id
where start_date between "2019-10-01" and "2019-12-31"
and c.service_id not in
	(select
		service_id
	from contracts
	where start_date between "2019-01-01" and "2019-05-31"
	group by 1
	)
group by 1, 2, 3, 4, 5, 6
