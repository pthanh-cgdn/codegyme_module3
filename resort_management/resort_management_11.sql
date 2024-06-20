
select distinct
	*
from additional_services
where service_id in 
	(select
		de.additional_service_id
	from contracts c
	join customers cus
	on c.customer_id = cus.customer_id
	join customer_types t
	on cus.customer_type_id = t.customer_type_id
	join contract_details de
	on c.contract_id = de.contract_id
	where customer_type_name = "Diamond" and (address = "Vinh" or address = "Quang Ngai")
    group by 1
	)