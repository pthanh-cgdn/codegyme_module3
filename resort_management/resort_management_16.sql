-- Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
SET SQL_SAFE_UPDATES = 0;
delete from employees
where employee_id not in
(select
	employee_id
from contracts
where start_date between '2017-01-01' and '2019-12-31'
group by 1
)