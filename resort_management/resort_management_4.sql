select
cnt.customer_id
,cus.name
,cnt.contract_cnt
from 
(select 
customer_id
,count(contract_id) as contract_cnt
from contracts c
group by customer_id
order by contract_cnt
) cnt
join customers cus
on cnt.customer_id = cus.customer_id
join customer_types cus_type
on cus.customer_type_id = cus_type.customer_type_id
where cus_type.customer_type_name = 'DIAMOND'
order by 3