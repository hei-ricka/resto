create table if not exists "ingredient_template" (
    "id" varchar(255) primary key,
    "name" varchar(255) not null,
    "unit" varchar(255) references "unit"("id") not null
);