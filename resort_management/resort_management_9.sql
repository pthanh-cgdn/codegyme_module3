-- Thực hiện thống kê doanh thu theo tháng, 
-- nghĩa là tương ứng với mỗi tháng trong năm 2019 
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select
	month(start_date) as month
    ,count(customer_id) as number_customer
from contracts
where start_date between '2019-01-01' and '2019-12-31'
group by 1
order by 1