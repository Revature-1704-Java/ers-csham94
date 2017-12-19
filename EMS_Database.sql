drop user ems_user cascade;

CREATE USER ems_user
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to ems_user;
GRANT resource to ems_user;
GRANT create session TO ems_user;
GRANT create table TO ems_user;
GRANT create view TO ems_user;

conn ems_user/p4ssw0rd;

create table Employee
(
    EmployeeID number not null,
    FirstName varchar2(20) not null,
    LastName varchar2(20) not null,
    EmpPassword varchar2(20) not null,
    Title varchar2(20) not null,
    constraint PK_Employee primary key (EmployeeID)
);

create table Reimbursement
(
    ReimbursementID number not null,
    Description varchar2(100) not null,
    CostTotal number not null,
    Status varchar2(10) not null,
    EmployeeID number not null,
    constraint PK_Reimbursement primary key (ReimbursementID)
);

alter table Reimbursement 
add constraint FK_ReimbursementEmployeeID
FOREIGN KEY (EmployeeID) 
REFERENCES Employee (EmployeeID);

insert into ems_user.Employee values (1, 'Jake', 'Johnson', 'pa55word', 'Employee');
insert into ems_user.Employee values (2, 'Janet', 'Jameson', 'default', 'Employee');
insert into ems_user.Employee values (3, 'Jonah', 'Jonas', '9455w0rd', 'Employee');
insert into ems_user.Employee values (4, 'John', 'Jakeson', 'mypassw07d', 'Employee');
insert into ems_user.Employee values (5, 'Jim', 'Juice', 'koolaidm4n', 'Employee');
insert into ems_user.Employee values (6, 'Janise', 'Jefferson', 'securepassword', 'Employee');
insert into ems_user.Employee values (7, 'Jeff', 'Josephs', 'lollipop', 'Employee');
insert into ems_user.Employee values (8, 'Jessica', 'Johns', 'l0lip0pe', 'Employee');
insert into ems_user.Employee values (9, 'Jolene', 'Jenkins', 'gherkin', 'Employee');
insert into ems_user.Employee values (10, 'Julia', 'Johnston', 'sauce6055', 'Manager');

insert into ems_user.Reimbursement values (1, 'Certification', 19.99, 'Pending', 1);
insert into ems_user.Reimbursement values (2, 'Relocation', 450.00, 'Accepted', 5);
insert into ems_user.Reimbursement values (3, 'Certification', 25.00, 'Pending', 2);
insert into ems_user.Reimbursement values (4, 'Certification', 5.99, 'Denied', 7);
insert into ems_user.Reimbursement values (5, 'Relocation', 200.40, 'Pending', 8);
insert into ems_user.Reimbursement values (6, 'Advance', 230.00, 'Accepted', 3);
insert into ems_user.Reimbursement values (7, 'Certification', 45.00, 'Pending', 3);
insert into ems_user.Reimbursement values (8, 'Certification', 19.99, 'Pending', 7);

SELECT * FROM ems_user.Reimbursement;