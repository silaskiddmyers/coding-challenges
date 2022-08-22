-- SQL Lab

--2.0 SQL Queries

--2.1
--  Select all records from the Employee table.
select * from employee;

--Select all records from the Employee table where last name is King
select * from employee where last_name = 'King';

-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from employee where first_name = 'Andrew' and reports_to is null;

--2.2
-- Select all albums in Album table and sort result set in descending order by title.
select * from album order by title desc;
-- Select first name from Customer and sort result set in ascending order by city
select first_name from customer order by city asc;

--2.3
--Insert two new records into Genre table
insert into genre values(26, 'Horror'),
(27, 'Romance');
select * from genre; -- I know I don't need this it's just to check my work
-- Insert 2 new records into employee table
select * from employee;
insert into employee(employee_id, last_name, first_name) values (9, 'Doe', 'John'),
(10, 'Freeman', 'Morgan');
-- insert 2 new records into customer table
select * from customer;
insert into customer(customer_id, last_name, first_name, email) values (60, 'Watrous', 'Bill', 'tromboneisgreat@gmial.com'),
(61, 'Coltrane', 'John', 'saxisgreat@gmail.com');
update customer set email = 'tromboneisgreat@gmail.com' where customer_id = 60; -- oops

--2.4 update 
-- Update Aaron Mitchell in Customer table to Robert Walter
update customer set last_name = 'Walter', first_name = 'Robert' where last_name = 'Mitchell' and first_name = 'Aaron';
select * from customer where last_name = 'Walter' or last_name = 'Mitchell'; -- can see there's no more Aaron Mitchell
--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
select * from artist;
update artist set name = 'CCR' where name = 'Creedence Clearwater Revival';

--2.5 like
select * from invoice;
select * from invoice where billing_address::text like 'T%';

--2.6 between
--Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 and 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where hire_date between '2003-06-01' and '2004-03-01';

--2.7 delete
delete from invoice_line where invoice_id in (
	select i.invoice_id
	from invoice i
	where i.customer_id = (
		select c.customer_id
		from customer c
		where c.first_name = 'Robert'
		and c.last_name = 'Walter'));
	
delete from invoice where customer_id = 32; 
delete from customer where first_name = 'Robert' and last_name = 'Walter';

--SQL Functions
-- 3.1 System Defined Definitions
--create function that returns current time
select now();
--create function that returns length of mediatype from meia type table
select length(name) from media_type mt ;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
select total from invoice;
select avg(total) from invoice;
--Task – Create a function that returns the most expensive track
select max(unit_price) from track t ;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
select * from invoice_line;
create or replace function avg_invoice_price()
	returns numeric(10,2) as $$
	begin
		declare counter integer := 0;
		average numeric(10,2) := 0.00;
		p numeric(10,2) := 0.00;
		
		begin
			for p in (select unit_price from invoice_line il) loop
				average = average + p;
				counter = counter + 1;
			end loop;
			average = average / counter;
			return average;	
		end; 
	end;
	$$ language PLPGSQL;

select avg_invoice_price();