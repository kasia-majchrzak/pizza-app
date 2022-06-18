create table pizza
(
    id       bigint       not null auto_increment,
    name     varchar(255) not null,
    description     varchar(255) not null,
    prize decimal(10,2) not null,
    primary key (id)
);
