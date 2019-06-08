use toeiconline;
select * from user;
insert into user(name, password, fullname, createddate, roleid) values ('admin', '123456', 'admin', CURRENT_TIMESTAMP,1);
insert into user(name, password, fullname, createddate, roleid) values ('hoc', '123456', 'Ha Nguyen Thai Hoc', CURRENT_TIMESTAMP,2);