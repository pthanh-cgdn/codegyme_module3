select
*
from customers
where 1=1
and (address = "Da Nang" or address = "Quang Tri")
and age between 18 and 50;