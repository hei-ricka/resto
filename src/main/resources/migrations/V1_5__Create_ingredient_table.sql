create table if not exists "ingredient" (
    "id" varchar(255) primary key,
    "quantity" varchar(255) not null,
    "ingredient_template" varchar(255) references "ingredient_template"("id") not null,
    "menu" varchar(255) references "menu"("id") not null
);
