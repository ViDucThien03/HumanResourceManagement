create database qlns;
use qlns;

create table department
(
	departmentid varchar(10) primary key not null,
    departmentname nvarchar(255) not null,
    departmentaddress nvarchar(100) not null
);

create table positions
(
	positionid varchar(10) primary key not null,
    positionname varchar(255) not null,
    departmentid varchar(10),
    foreign key (departmentid) references department(departmentid)
);

create table employee
(
	employeeid varchar(10) primary key not null,
    employeename nvarchar(50) not null,
    employeebirth date,
    employeeaddress nvarchar(255) not null,
    employeehometown nvarchar(50) not null,
    employeephone varchar(10) not null,
	employeeworkday date not null,
    employeeexp varchar(50) not null,
    positionid varchar(10),
    departmentid varchar(10),
    foreign key (positionid) references positions(positionid),
    foreign key (departmentid) references department(departmentid)
);

create table salary
(
	salaryid varchar(10) primary key not null,
	salarygrade decimal(1,1) not null,
    salarybasic decimal not null,
    salaryfactor decimal(1.1) not null,
    positionid varchar(10),
    employeeid varchar(10),
    foreign key (positionid) references positions(positionid),
    foreign key (employeeid) references employee(employeeid)
);

create table assignedwork
(
	jobid varchar(10) primary key not null,
	deliverydate date not null,
    descriptions nvarchar(255) not null,
    deadline date not null,
    workprogressemployee nvarchar(50) not null,
    employeeid varchar(10),
    foreign key (employeeid) references employee(employeeid)
);
create table Accounts
(
	accountid varchar(10) not null primary key,
    UserName varchar(30) not null unique,
    Active bit not null,
    Password varchar(20) not null,
    UserRole varchar(20) not null
);
ALTER TABLE employee
add image varchar(50);

ALTER TABLE salary ADD COLUMN totalsalary DECIMAL(10, 2) DEFAULT 0;
-- Cập nhật giá trị total_salary từ các trường khác
SET SQL_SAFE_UPDATES = 0;
UPDATE salary
SET totalsalary = salarygrade*salarybasic*salaryfactor;
drop table employee;
drop table department;
drop table assignedwork;
drop table salary;
drop table positions;
select jobid,descriptions,deliverydate,deadline,workprogressemployee,employeename,employee.employeeid from assignedwork inner join employee on assignedwork.employeeid = employee.employeeid where jobid="JW02";
select * from assignedwork;
SELECT positions.positionid, positions.positionname, department.departmentname FROM positions INNER JOIN department ON positions.departmentid = department.departmentid;
select employeeid,employeename,employeebirth,employeeaddress,employeehometown,employeephone,positionname from employee inner join positions on employee.positionid = positions.positionid;
INSERT INTO assignedwork (jobid, descriptions, deliverydate, deadline, workprogressemployee, employeeid) VALUES (?, ?, ?, ?, ?, ?);
update assignedwork set deliverydate="2023-07-2023-07-10",descriptions="Gì đó",deadline="2023-07-10",workprogressemployee="Chưa hoàn thành",employeeid="2021603374" where jobid="JW02";

SELECT 
    e.employeeid, 
    e.employeename, 
    COUNT(CASE WHEN aw.workprogressemployee = 'Đã hoàn thành' THEN 1 END) AS completed_tasks,
    COUNT(*) AS total_tasks,
    (COUNT(CASE WHEN aw.workprogressemployee = 'Đã hoàn thành' THEN 1 END) / COUNT(*) * 100) AS completion_percentage
FROM employee e 
JOIN assignedwork aw ON e.employeeid = aw.employeeid 
GROUP BY e.employeeid, e.employeename;
SELECT e.employeeid,  e.employeename, e.image, COUNT(CASE WHEN aw.workprogressemployee = 'Hoàn thành' THEN 1 END) AS completed_tasks, ROUND(COUNT(CASE WHEN aw.workprogressemployee = 'Hoàn thành' THEN 1 END) * 100.0 / COUNT(*), 2) AS completion_percentage FROM employee e  JOIN assignedwork aw ON e.employeeid = aw.employeeid  GROUP BY e.employeeid, e.employeename ORDER BY completion_percentage asc LIMIT 2;
SELECT e.employeeid, e.employeename, 
COUNT(CASE WHEN aw.workprogressemployee = 'Hoàn thành' THEN 1 END) AS completed_works, 
ROUND(COUNT(CASE WHEN aw.workprogressemployee = 'Hoàn thành' THEN 1 END) * 100.0 / COUNT(*), 2) AS completion_percentage 
FROM employee e JOIN assignedwork aw ON e.employeeid = aw.employeeid GROUP BY e.employeeid, e.employeename  
ORDER BY completion_percentage ASC LIMIT 3;
