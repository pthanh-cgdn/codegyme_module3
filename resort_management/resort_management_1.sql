create database resort_management;
use resort_management;
create table customer_types (
customer_type_id int,
customer_type_name varchar(45),
primary key (customer_type_id)
);

create table positions (
position_id int,
name_position varchar(45),
primary key (position_id)
);
create table departments (
department_id int,
department_name varchar(45),
primary key (department_id)
);
create table degrees (
degree_id int,
degree_name varchar(45),
primary key (degree_id)
);
create table rent_types (
rent_type_id int,
rent_type_name varchar(45),
price int,
primary key (rent_type_id)
);
create table service_types (
service_type_id int,
service_type_name varchar(45),
primary key (service_type_id)
);
create table additional_services (
service_id int,
service_name varchar(45),
price int,
quantity int,
status varchar(45),
primary key (service_id)
);

create table employees (
employee_id int,
name varchar(45),
position_id int,
degree_id int,
department_id int,
dob date,
identification_card varchar(45),
salary varchar(45),
phone_number varchar(45),
email varchar(45),
address varchar(45),
primary key (employee_id),
foreign key (position_id) references positions (position_id),
foreign key (degree_id) references degrees (degree_id),
foreign key (department_id) references departments(department_id)
);

create table customers(
customer_id int,
customer_type_id int,
name varchar(45),
dob date,
identification_card varchar(45),
phone_number varchar(45),
email varchar(45),
address varchar(45),
primary key (customer_id),
foreign key (customer_type_id) references customer_types(customer_type_id)
);
create table main_services (
service_id int,
service_name varchar(45),
area int,
floor int,
max_occupation int,
price int,
rent_type_id int,
service_type_id int,
status varchar(45),
primary key (service_id),
foreign key (rent_type_id) references rent_types (rent_type_id),
foreign key (service_type_id) references service_types (service_type_id)
);

create table contracts (
contract_id int,
employee_id int,
customer_id int,
service_id int,
start_date date,
end_date date,
deposit int,
total_amount int,
primary key (contract_id),
foreign key (employee_id) references employees(employee_id),
foreign key (customer_id) references customers(customer_id),
foreign key (service_id) references main_services(service_id)
);
create table contract_details (
contract_detail_id int,
contract_id int,
additional_service_id int,
quantity int not null,
primary key (contract_detail_id),
foreign key (contract_id) references contracts (contract_id),
foreign key (additional_service_id) references additional_services (service_id)
);

