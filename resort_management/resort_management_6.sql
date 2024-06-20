select
	service_id
    ,service_name
    ,area
    ,price
    ,service_type_name
from main_services s
join service_types t
on s.service_type_id = t.service_type_id
where service_id not in
	(select
		service_id
	from contracts
	where
		start_date >= '2019-01-01'
	group by 1
	)
