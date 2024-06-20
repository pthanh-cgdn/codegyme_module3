create database sale_management;
use sale_management;
create table customers(
id int primary key,
name varchar(45),
age int
);
create table products(
id int primary key,
name varchar(45),
price int
);
create table orders(
id int primary key,
customer_id int,
created_day date,
total_amount int,
foreign key (customer_id) references customers(id)
);
create table order_details(
order_id int,
product_id int,
quantity int,
primary key (order_id,product_id),
foreign key (order_id) references orders(id),
foreign key (product_id) references products(id)
);