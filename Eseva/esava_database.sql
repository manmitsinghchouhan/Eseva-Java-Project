create database Esevaa;

show databases;

use Esevaa;

create table signup1
( username varchar(20),
name varchar(20),
security varchar(100),
password varchar(20),
answer varchar(50)
);


drop table signup1;

show tables;

select * from signup1;

create table customer(
username varchar(20),
id varchar(30),
number varchar(30),
name varchar (30),
gender varchar (20),
emergency_no varchar(30),
address varchar(50),
phone varchar(15),
email varchar(40));

select * from customer;


alter table customer
add Profession varchar(20);





 

