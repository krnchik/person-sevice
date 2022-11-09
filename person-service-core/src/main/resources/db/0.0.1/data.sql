insert into medical.medical_card(id, client_status, comment, med_status, registry_dt)
values (1, 'd', 'какое-то сообщение', 't', '2022-02-02');
insert into medical.medical_card(id, client_status, comment, med_status, registry_dt)
values (2, 'r', 'какой-то комментарий', 'n', '2022-02-03');
insert into medical.medical_card(id, client_status, comment, med_status, registry_dt)
values (3, 'm', 'какой-то комментарий', 'b', '2022-02-03');

insert into medical.contact(id, email, phone_number, profile_link)
values (1, 'krn@yandex.ru', '+79239485788', '@krn');
insert into medical.contact(id, email, phone_number, profile_link)
values (2, 'gfj@yandex.ru', '+79559484788', '@gfj');
insert into medical.contact(id, email, phone_number, profile_link)
values (3, 'gus@yandex.ru', '+79559294388', '@gus');

insert into medical.illness(id, appearance_dttm, heaviness, recovery_dt, type_id, medical_card_id)
values (1, '2022-02-03 20:00:00', 'v', '2022-02-10', 1, 1);
insert into medical.illness(id, appearance_dttm, heaviness, recovery_dt, type_id, medical_card_id)
values (2, '2022-02-03 18:00:00', 'h', '2022-02-11', 2, 2);
insert into medical.illness(id, appearance_dttm, heaviness, recovery_dt, type_id, medical_card_id)
values (3, '2022-02-03 17:00:00', 's', '2022-02-11', 3, 3);

insert into medical.address(id, building, city, country_id, flat, index, street, contact_id)
values (1, 'street Red', 'NN', 100, '54', 600400, 'street Red', 1);
insert into medical.address(id, building, city, country_id, flat, index, street, contact_id)
values (2, 'street Red', 'NN', 101, '55', 600400, 'street Red', 2);
insert into medical.address(id, building, city, country_id, flat, index, street, contact_id)
values (3, 'street Red', 'NN', 102, '56', 600400, 'street Red', 3);

insert into medical.person_data(id, age, birth_dt, first_name, last_name, sex, contact_id, medical_card_id, parent_id)
values (1, 22, '2000-02-03', 'Ivan', 'Petrov', 'm', 1, 1, null);
insert into medical.person_data(id, age, birth_dt, first_name, last_name, sex, contact_id, medical_card_id, parent_id)
values (2, 21, '2001-02-03', 'Sidor', 'Petrov', 'm', 2, 2, null);
insert into medical.person_data(id, age, birth_dt, first_name, last_name, sex, contact_id, medical_card_id, parent_id)
values (3, 20, '2002-02-03', 'Tom', 'Braun', 'm', 3, 3, null);