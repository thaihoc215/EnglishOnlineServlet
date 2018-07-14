use toeiconline;

create table user(
	userid bigint not null primary key auto_increment,
    name varchar(255) null,
    password varchar(255) null,
    fullname varchar(300) null,
    createddate timestamp null
);

create table role(
	roleid bigint not null primary key auto_increment,
	name varchar(100) null
);

create table listenguideline(
	listenguidelineid bigint not null primary key auto_increment,
    title varchar(512) null,
    image varchar(255) null,
    content text null,
    createddate timestamp null,
    modifieddate timestamp
);

create table comment(
	commentid bigint not null primary key auto_increment,
    content text null,
    userid bigint null,
    listenguidelineid bigint null,
    createddate timestamp null
);