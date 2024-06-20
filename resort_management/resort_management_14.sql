
select
	c.contract_id
    ,service_name
    ,additional_service_name
    ,number_orders
from
	(select
		se.service_id as additional_service_id
		,se.service_name as additional_service_name
		,count(de.contract_id) as number_orders
	from contract_details de
	join contracts c
	on de.contract_id = c.contract_id
	join additional_services se
	on de.additional_service_id = se.service_id
	group by 1, 2
    having number_orders = 1
	) temp
join contract_details de
on temp.additional_service_id = de.additional_service_id
join contracts c
on de.contract_id = c.contract_id
join main_services m 
on c.service_id = m.service_id