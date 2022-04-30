create table product
(
    id int not null,
    name varchar not null,
    description varchar not null,
    prise int not null
);

create unique index product_id_uindex
    on product (id);

alter table product
    add constraint product_pk
        primary key (id)

-- auto-generated definition
create sequence hibernate_sequence
    as integer;

alter sequence hibernate_sequence owner to postgres;

