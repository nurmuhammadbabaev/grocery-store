create table carts
(
    id      int8 generated by default as identity,
    user_id int8,
    primary key (id)
);
create table carts_products
(
    cart_id     int8 not null,
    products_id int8 not null
);
create table categories
(
    id   int8 generated by default as identity,
    name varchar(255),
    primary key (id)
);
create table orders
(
    id        int8 generated by default as identity,
    date      date,
    status_id int8,
    user_id   int8,
    primary key (id)
);
create table orders_products
(
    order_id    int8 not null,
    products_id int8 not null
);
create table payment_methods
(
    id             int8 generated by default as identity,
    payment_method varchar(255),
    primary key (id)
);
create table photos
(
    id         int8 generated by default as identity,
    path       varchar(100000),
    photo_name varchar(255),
    size       int8,
    type       varchar(255),
    primary key (id)
);
create table products
(
    id          int8 generated by default as identity,
    description varchar(255),
    name        varchar(255),
    price       numeric(19, 2),
    category_id int8,
    photo_id    int8,
    primary key (id)
);
create table reports
(
    id   int8 generated by default as identity,
    date date,
    text varchar(255),
    type varchar(255),
    primary key (id)
);
create table status
(
    id   int8 generated by default as identity,
    name varchar(255),
    primary key (id)
);
create table users
(
    id       int8 generated by default as identity,
    address  varchar(255),
    email    varchar(255),
    name     varchar(255),
    password varchar(255),
    primary key (id)
);
alter table if exists carts_products
    add constraint UK_5hmu94nhbw84m0nbnwb1bp2mx unique (products_id);
alter table if exists orders_products
    add constraint UK_qmviv5y7625wak8tjq4nirybh unique (products_id);
alter table if exists carts
    add constraint FKb5o626f86h46m4s7ms6ginnop foreign key (user_id) references users;
alter table if exists carts_products
    add constraint FKq9ns7lphr8im6vg3i5dwknsbn foreign key (products_id) references products;
alter table if exists carts_products
    add constraint FK3nvguygrfbn661omvvu2uafu5 foreign key (cart_id) references carts;
alter table if exists orders
    add constraint FKnoettwqr56yaai4i8nwxg4huo foreign key (status_id) references status;
alter table if exists orders
    add constraint FK32ql8ubntj5uh44ph9659tiih foreign key (user_id) references users;
alter table if exists orders_products
    add constraint FKqgxvu9mvqx0bv2ew776laoqvv foreign key (products_id) references products;
alter table if exists orders_products
    add constraint FKe4y1sseio787e4o5hrml7omt5 foreign key (order_id) references orders;
alter table if exists products
    add constraint FKog2rp4qthbtt2lfyhfo32lsw9 foreign key (category_id) references categories;
alter table if exists products
    add constraint FKaqdakjmujj96p0dn0143niopy foreign key (photo_id) references photos;