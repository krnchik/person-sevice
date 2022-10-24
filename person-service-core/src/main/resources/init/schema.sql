create table if not exists address
(
    id         bigint       not null
        primary key,
    country_id bigint       not null,
    city       varchar(255) not null,
    index      integer      not null,
    street     varchar(255) not null,
    building   varchar(32)  not null,
    flat       varchar(32),
    contact_id bigint
        references schema_name.contact
);

create table if not exists contact
(
    id           bigint       not null
        primary key,
    phone_number varchar(32)  not null,
    email        varchar(128) not null,
    profile_link text
);

create table if not exists illness
(
    id              bigint    not null
        primary key,
    type_id         bigint    not null,
    heaviness       char      not null,
    appearance_dttm timestamp not null,
    recovery_dt     date      not null,
    medical_card_id bigint
        references schema_name.medical_card
);

create table if not exists medical_card
(
    id            bigint not null
        primary key,
    client_status char   not null,
    med_status    char,
    registry_dt   date   not null,
    comment       text
);

create table if not exists person_data
(
    id              bigint       not null
        primary key,
    first_name      varchar(255) not null,
    last_name       varchar(255) not null,
    birth_dt        date         not null,
    age             smallint     not null,
    sex             char         not null,
    contact_id      bigint
        references schema_name.contact,
    medical_card_id bigint
        references schema_name.medical_card,
    parent_id       bigint
        references schema_name.person_data,
    constraint person_data_check
        check (parent_id <> id)
);