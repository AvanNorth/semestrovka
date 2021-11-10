create table if not exists users
(
    id serial not null primary key,
    first_name varchar(30),
    last_name varchar(30),
    phone bigint not null unique,
    password_hash varchar(100) not null,
    email varchar(100) not null unique,
    avatar_id integer references file_info
);

create table if not exists file_info
(
    id serial not null primary key,
    original_file_name varchar(100),
    storage_file_name varchar(100) not null,
    size bigint not null,
    type varchar(100)
);

create table if not exists labs
(
    id serial not null primary key,
    name varchar(100) not null,
    email varchar(100) not null unique,
    phone bigint not null unique,
    password_hash varchar(100) not null,
    avatar_id bigint references file_info
);



create table if not exists orders
(
    id serial not null primary key,
    user_id bigint not null,
    lab_id bigint not null,
    cost bigint not null,
    date timestamp not null
);

create table if not exists lab_photos
(
    file_id bigint not null references file_info,
    lab_id bigint not null references labs
);


create table if not exists services
(
    id serial not null primary key,
    lab_id bigint not null references labs,
    name varchar(100) not null,
    description varchar(255) not null,
    avatar_id bigint references file_info
);

