create sequence global_seq start with 1 increment by 1;

    create table dishes (
        id integer not null,
        name varchar(255) not null,
        date date,
        price numeric(19,2) not null,
        restaurant_id integer not null,
        primary key (id)
    );

    create table restaurants (
        id integer not null,
        name varchar(255) not null,
        time_zone varchar(255),
        primary key (id)
    );

    create table user_roles (
        user_id integer not null,
        role varchar(255)
    );

    create table users (
        id integer not null,
        name varchar(255) not null,
        email varchar(255) not null,
        enabled boolean not null,
        password varchar(255) not null,
        registered timestamp default now(),
        primary key (id)
    );

    create table votes (
        id integer not null,
        date date,
        restaurant_id integer not null,
        user_id integer not null,
        primary key (id)
    );

    alter table users 
        add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table votes 
        add constraint votes_unique_date_user_idx unique (user_id, date);

    alter table dishes 
        add constraint FKpslsa9mci7gsfhwukb3mx7s6n 
        foreign key (restaurant_id) 
        references restaurants;

    alter table user_roles 
        add constraint FKhfh9dx7w3ubf1co1vdev94g3f 
        foreign key (user_id) 
        references users;

    alter table votes 
        add constraint FK93nqd6kky7cyvbe4q1eup9gcx 
        foreign key (restaurant_id) 
        references restaurants 
        on delete cascade;

    alter table votes 
        add constraint FKli4uj3ic2vypf5pialchj925e 
        foreign key (user_id) 
        references users 
        on delete cascade;
