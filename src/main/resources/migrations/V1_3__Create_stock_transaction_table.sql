create table if not exists "stock_transaction" (
    "id" varchar(255) primary key,
    "quantity" decimal(10,5) not null,
    "transaction_datetime" timestamp default current_timestamp not null,
    "ingredient_template" varchar(255) references "ingredient_template"("id") not null,
    "restaurant" varchar(255) references "restaurant"("id") not null
);
