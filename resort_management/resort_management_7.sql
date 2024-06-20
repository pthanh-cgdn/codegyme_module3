-- Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
-- nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
select
	service_id
    ,service_name
    ,area
    ,max_occupation
    ,price
    ,service_type_name
from main_services s
join service_types t
on s.service_type_id = t.service_type_id
where service_id not in
	(select
		service_id
	from contracts
	where
		start_date between '2019-01-01' and '2019-12-31'
	group by 1
	)
    and service_id in 
    (select
		service_id
	from contracts
	where
		start_date between '2018-01-01' and '2018-12-31'
	group by 1
	)
