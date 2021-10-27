-- auto-generated definition
create table Roles
(
    id   serial      not null constraint roles_pk primary key,
    name varchar(20) not null
);
alter table Roles owner to postgres;

create table Users
(
    id    serial not null constraint Users_pk  primary key,
    login    varchar(50),
    password varchar(500),
    role_id  integer constraint Users_Roles_id_fk references Roles
);

alter table Users  owner to postgres;

create unique index Users_login_uindex on Users (login);

insert into Roles(name) values ('ROLE_ADMIN');
insert into Roles(name) values ('ROLE_USER');

create table Disciplines
(
	id serial not null constraint disciplines_pk primary key,
	name varchar(30) not null
);
alter table Disciplines owner to postgres;

create table Videos(
    id serial not null constraint videos_pk primary key,
    title varchar(30) not null,
    theme varchar(30) not null,
    discipline_id integer constraint videos_disciplines_id_fk references Disciplines,
    author varchar(30) not null,
    date date not null,
	url varchar(74) not null,
    description varchar(250)
);
alter table Videos owner to postgres;

insert into Disciplines(name) values ('Biology');
insert into Disciplines(name) values ('Chemistry');
insert into Disciplines(name) values ('ComputerScience');
insert into Disciplines(name) values ('English');
insert into Disciplines(name) values ('Maths');
insert into Disciplines(name) values ('Other');



