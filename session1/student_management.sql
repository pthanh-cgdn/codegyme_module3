create database student_management;
use student_management;
CREATE TABLE class
(
id int primary key,
name varchar(200)
);
CREATE TABLE teacher(
id int primary key,
name varchar(200),
country varchar(50),
age int
)