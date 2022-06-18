create table order (
    id       bigint       not null auto_increment,
    orderedOn datetime not null,
    totalPrize decimal(10, 2) not null,
    orderState nvarchar(255) not null,
    user_id bigint not null,
    foreign key (user_id) references user(id),
    primary key (id)
);