insert into position(id, name) values(1, 'DEV');
insert into position(id, name) values(2, 'QA');

insert into person(id, name, lastname, address, cellphone, city_name) values(1, 'Miguelangel', 'Cardenas', 'Iquitos Av', '+51-970505375', 'Lima');
insert into person(id, name, lastname, address, cellphone, city_name) values(2, 'Homer', 'Simpson', '123 Evergreen Av', '+1-000111222333', 'Springfield');
insert into person(id, name, lastname, address, cellphone, city_name) values(3, 'Lisa', 'Simpson', '123 Evergreen Av', '+1-999-5555-333', 'Springfield');

insert into employee (id, person_id, position_id, salary) values(1, 1, 1, 1500);
insert into employee (id, person_id, position_id, salary) values(2, 2, 2, 1000);
insert into employee (id, person_id, position_id, salary) values(3, 3, 1, 1300);

create index person_name_idx on person(name, lastname);
create index position_idx on position(name);