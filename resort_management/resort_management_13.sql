-- Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

select
	service_id
    ,service_name
    ,price
    ,number_orders
    ,max(number_orders) as highest_number_orders
from
	(select
		se.service_id
		,se.service_name
		,se.price
		,count(de.contract_id) as number_orders
	from contract_details de
	join contracts c
	on de.contract_id = c.contract_id
	join additional_services se
	on de.additional_service_id = se.service_id
	group by 1, 2, 3
	) temp
group by 1, 2, 3
having highest_number_orders = number_orders
order by 1, 2, 3;