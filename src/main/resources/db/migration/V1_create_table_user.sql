create table user
(
    id       bigint       not null auto_increment,
    email    varchar(255) not null unique,
    firstname     varchar(255) not null,
    surname     varchar(255) not null,
    password varchar(255) not null,
    birthdate datetime not null,
    primary key (id)
);
