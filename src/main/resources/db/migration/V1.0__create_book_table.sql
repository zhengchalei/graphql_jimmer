create table book
(
    id    bigint not null primary key auto_increment,
    name varchar(255)
);

insert into book(name)
values ('Spring Boot'), ( 'Spring'),('Spring Framework');