create database cinema;
use cinema;
create table movies (
id INT PRIMARY KEY AUTO_INCREMENT ,
title VARCHAR(255) NOT NULL,
director VARCHAR(255),
release_year INT,
duration INT,
description TEXT
);
CREATE TABLE rooms (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  row_num INT NOT NULL,
  cols_num INT NOT NULL
);
CREATE TABLE Showtimes (
  id INT PRIMARY KEY AUTO_INCREMENT,
  movie_id INT NOT NULL,
  room_id INT,
  day DATE NOT NULL,
  showtime TIMESTAMP NOT NULL,
  FOREIGN KEY (movie_id) REFERENCES Movies(id),
  FOREIGN KEY (room_id) REFERENCES rooms(id)
);
CREATE TABLE orders (
id INT PRIMARY KEY AUTO_INCREMENT,
showtime_id int not null,
customer_phone VARCHAR(10) NOT NULL,
number_ticket int,
total_amount INT,
FOREIGN KEY (showtime_id) REFERENCES showtimes(id)
);
CREATE TABLE tickets (
id INT PRIMARY KEY AUTO_INCREMENT,
order_id int,
row_num INT NOT NULL,
cols_num INT NOT NULL,
FOREIGN KEY (order_id) REFERENCES orders(id)
);
CREATE TABLE prices(
id INT PRIMARY KEY AUTO_INCREMENT,
room_id int,
movie_id int,
price int not null,
FOREIGN KEY (movie_id) REFERENCES Movies(id),
FOREIGN KEY (room_id) REFERENCES rooms(id)
);


