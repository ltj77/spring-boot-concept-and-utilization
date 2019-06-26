drop table if exists account;
create table account
(
    id       bigint not null auto_increment,
    password varchar(255),
    username varchar(255),
    primary key (id)
);