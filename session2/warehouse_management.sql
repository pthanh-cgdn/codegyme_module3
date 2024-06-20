create database warehouse_management;
use warehouse_management;
create table products(
product_id int primary key,
product_name varchar(45)
);
create table good_delivery_notes(
id int primary key,
created_day date
);
create table good_delivery_orders(
id int primary key,
note_id int,
product_id int,
quantity int,
price float,
foreign key (note_id) references good_delivery_notes(id),
foreign key (product_id) references products(product_id)
);
create table good_receive_notes(
id int primary key,
created_day date
);
create table good_receive_orders(
id int primary key,
note_id int,
product_id int,
quantity int,
price float,
foreign key (note_id) references good_receive_notes(id),
foreign key (product_id) references products(product_id)
);
create table suppliers(
id int primary key,
name varchar(45),
address varchar(255)
);
create table supplier_phone_numbers(
supplier_id int not null,
phone_number varchar(45) primary key,
foreign key (supplier_id) references suppliers(id)
);
create table orders(
order_id int primary key,
product_id int,
created_day date,
foreign key (product_id) references products(product_id)
);
create table order_details(
id int primary key,
order_id int,
supplier_id int,
quantity int,
price float,
product_id int,
created_day date,
foreign key (supplier_id) references suppliers(id),
foreign key (order_id) references orders(order_id),
foreign key (product_id) references products(product_id)
);
