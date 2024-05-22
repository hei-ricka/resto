create table if not exists "menu" (
    "id" varchar(255) primary key,
    "name" varchar(255) not null,
    "price" decimal(18,5) check ("price" > 0) not null
);