use sale_management;
insert into customers values
(1, "Minh Quan", 10),
(2, "Ngoc Oanh", 20),
(3, "Hong Ha", 50);

insert into orders (id, customer_id, created_day) values
(1, 1, "2006-03-21"),
(2, 2, "2006-03-23"),
(3, 1, "2006-03-16");

insert into products values
(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into order_details values
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

select
*
from orders;

select
	o.customer_id
    ,c. name as customer_name
    ,o.id
    ,group_concat(p.name) as products
from orders o
join customers c
on o.customer_id = c.id
join order_details de
on o.id = de.order_id	
join products p
on de.product_id = p.id
group by 1, 2, 3
order by 1, 2, 3;

select
*
from customers
where id not in
(select 
customer_id
from orders
group by 1
);

select
	o.id
    ,created_day
    ,sum(quantity*price) as total_amount
from orders o
join order_details de
on o.id = de.order_id
join products p
on de.product_id = p.id
group by 1
order by 1, 2

