select
*
from employees
where 1=1
and (name like "H%" or name like "T%" or name like "K%") 
and LENGTH(name) <= 15
