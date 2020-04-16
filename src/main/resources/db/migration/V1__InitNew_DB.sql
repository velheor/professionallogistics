create sequence hibernate_sequence start 1 increment 1;

ALTER USER postgres WITH SUPERUSER;

create table trip
(
    id        int8          not null,
    city_from varchar(2048) not null,
    city_to   varchar(2048) not null,
    price     int8          not null,
    weight    int8          not null,
    driver_id int8,
    user_id   int8,
    primary key (id)
);
create table truck
(
    model      varchar(2048),
    max_weight int8 not null,
    user_id    int8 not null
);

create table user_role
(
    user_id int8 not null,
    roles   varchar(255)
);

create table usr
(
    id              int8         not null,
    activation_code varchar(255),
    active          boolean      not null,
    email           varchar(255),
    password        varchar(255) not null,
    username        varchar(255) not null,
    primary key (id)
);

alter table if exists trip
    add constraint trip_user_fk
        foreign key (user_id) references usr;

alter table if exists truck
    add constraint truck_user_fk
        foreign key (user_id) references usr;

alter table if exists user_role
    add constraint user_role_user_fk
        foreign key (user_id) references usr;


