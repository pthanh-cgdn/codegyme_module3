-- Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm ID 
-- IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
select
	customer_id
    ,name
    ,email
    ,phone_number
    ,dob
    ,address
from customers

union all

select
	employee_id
    ,name
    ,email
    ,phone_number
    ,dob
    ,address
from employees