-- Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
update additional_services
set price = price*2
where service_id in
(select
	contract_detail_id
from
	(select
		de.contract_detail_id
		,count(de.contract_id) as number_contract
	from contracts c
	join contract_details de
	on c.contract_id = de.contract_id
	where start_date between '2019-01-01' and '2019-12-31'
	group by 1
	having number_contract > 10
	) temp
group by 1
)