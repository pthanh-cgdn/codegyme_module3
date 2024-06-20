explain SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.'; 
alter table customers add index idx_customername (customername);
EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';
ALTER TABLE customers ADD INDEX idx_full_name(contactFirstName, contactLastName);

