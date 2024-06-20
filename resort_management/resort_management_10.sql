select 
	c.contract_id
    ,c.start_date
    ,c.end_date
    ,c.deposit
    ,count(d.additional_service_id) as number_additional_services
from contracts c
left join contract_details d
on c.contract_id = d.contract_id
group by 1, 2, 3, 4