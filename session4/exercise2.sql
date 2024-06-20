delimiter //
create procedure show_customer_by_id(in id int)
begin
	select
		*
    from customers
    where customernumber = id;
end //

delimiter ;
call show_customer_by_id(175);