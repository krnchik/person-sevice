create table if not exists medical.medical_card
(
    id            bigint
        primary key,
    client_status char,
    med_status    char,
    registry_dt   date,
    comment       text
);

create table if not exists medical.contact
(
    id           bigint
        primary key,
    phone_number varchar(32),
    email        varchar(128),
    profile_link text
);

create table if not exists medical.address
(
    id         bigint primary key,
    country_id bigint,
    city       varchar(255),
    index      integer,
    street     varchar(255),
    building   varchar(32),
    flat       varchar(32),
    contact_id bigint
        references medical.contact
);

create table if not exists medical.illness
(
    id              bigint
        primary key,
    type_id         bigint,
    heaviness       char,
    appearance_dttm timestamp,
    recovery_dt     date,
    medical_card_id bigint
        references medical.medical_card
);

create table if not exists medical.person_data
(
    id              bigint
        primary key,
    first_name      varchar(255),
    last_name       varchar(255),
    birth_dt        date,
    age             smallint,
    sex             char,
    contact_id      bigint
        references medical.contact,
    medical_card_id bigint
        references medical.medical_card,
    parent_id       bigint
        references medical.person_data,
    constraint person_data_check
        check (parent_id <> id)
);

create sequence medical.contact_id_seq
start with 1
increment by 1
no minvalue
no maxvalue
cache 1;
alter sequence medical.contact_id_seq OWNED BY medical.contact.id;
alter table only medical.contact alter column id set default nextval('medical.contact_id_seq'::regclass);

CREATE VIEW multi_view AS
(
SELECT i.type_id, i.recovery_dt, mc.client_status
FROM medical.medical_card mc
INNER JOIN medical.illness i
on mc.id = i.medical_card_id
);