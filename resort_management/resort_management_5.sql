
select 
c.customer_id
,c.name
,t.customer_type_name
,co.contract_id
,m.service_name
,co.start_date
,co.end_date
,(ifnull(co.total_amount,0) + ifnull(ad.price,0)*ifnull(ad.quantity,0)) as total_amount
from customers c
join customer_types t
on c.customer_type_id = t.customer_type_id
left join contracts co
on c.customer_id = co.customer_id
left join main_services m
on co.service_id = m.service_id
left join additional_services ad
on co.service_id = ad.service_id
group by 1, 2, 3, 4, 5, 6, 7
order by 1, 2, 3, 4, 5, 6, 7