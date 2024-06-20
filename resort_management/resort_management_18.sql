-- Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
set SQL_SAFE_UPDATES = 0;
delete from contracts
where contract_id in 
(select
	customer_id
from
(select
	customer_id
    ,max(start_date) as latest_contract_day
from contracts
group by 1
having latest_contract_day < '2016-01-01'
) temp
group by 1
);
delete from customers
where customer_id not in 
(select
	customer_id
from contracts
where start_date < '2016-01-01'
group by 1
);