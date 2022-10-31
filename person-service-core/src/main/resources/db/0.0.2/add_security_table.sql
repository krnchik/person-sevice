create table if not exists medical.user
(
    id            bigint
        primary key,
    name varchar(255) unique not null,
    password  varchar(255) not null
);

create table if not exists medical.role
(
    id            bigint
        primary key,
    role varchar(255) unique not null
);

create table if not exists medical.user_role
(
    id bigint primary key ,
    user_id bigint not null references medical.user,
    role_id bigint not null references medical.role,
    unique (role_id, user_id)
)