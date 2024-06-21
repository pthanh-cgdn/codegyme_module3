-- cau1:
create database demo;
use demo;

-- cau2:
create table products(
id int primary key,
product_code varchar(45),
product_name varchar(200),
product_price int not null,
product_amount int not null default 0,
product_description varchar(255),
product_status varchar(100)
);
insert into products values
(1,"VNAPPLPHONE1","Iphone 16 pro",1000,10,"Apple Iphone 16 pro","new"),
(2,"VNSAMSPHONE1","Galaxy S10",999,4,"Samsung Galaxy S10","used"),
(3,"VNBKAVPHONE1","Bphone 2",699,2,"BKAV BPhone B2","new"),
(4,"VNAPPLPHONE2","Iphone 12 pro",599,20,"Apple Iphone 12 pro","new");

-- cau3:
explain select * from products where product_code = "VNAPPLPHONE1";
create index idx_prd_code on products(product_code);
create index idx_name_price on products(product_name, product_price);
explain select * from products where product_code = "VNAPPLPHONE1"; 

-- cau4:
create view view_product_info as
select
	product_code, product_name, product_price, product_status
from products;
update view_product_info
set product_price = 999 where product_code = "VNAPPLPHONE1";
select * from view_product_info;
drop view view_product_info;

-- cau5:
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure get_product_infor()
begin
	select
		*
    from products;
end//
delimiter ;
-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure add_product(id int,product_code varchar(45),product_name varchar(200),product_price int, product_amount int,product_description varchar(255),product_status varchar(100))
begin
	insert into products values 
    (id, product_code, product_name, product_price, product_amount,product_description,product_status);
end//
delimiter ;
-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure edit_product(id int,product_code varchar(45),product_name varchar(200),product_price int, product_amount int,product_description varchar(255),product_status varchar(100))
begin
	update products as prd
    set prd.product_code = product_code and prd.product_name = product_name and prd.product_price = product_price and prd.product_amount = product_amount and prd.product_description = product_description and prd.product_status = product_status
    where prd.id = id;
end//
delimiter ;
-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_product(id int)
begin
	delete from products where products.id = id;
end//
delimiter ;


