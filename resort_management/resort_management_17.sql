-- Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.
set SQL_SAFE_UPDATES = 0;
update customers
set customer_type_id = 
(
select customer_type_id from customer_types where customer_type_name = 'Diamond'
)
where customer_id in
(select
	customer_id
from
	(select
		c.customer_id
		,c.customer_type_id
		,customer_type_name
		,sum(total_amount) as total_amount
	from customers c
	join customer_types t
	on c.customer_type_id = t.customer_type_id
	join contracts con
	on c.customer_id = con.customer_id
	where start_date between '2019-01-01' and '2019-12-31'
	and customer_type_name = 'Platinum'
	group by 1, 2, 3
	having total_amount > 10000000
    ) temp
group by 1
)