DROP TABLE IF exists public.users;

CREATE TABLE public.users (
    id            int not null IDENTITY,
-- TODO more member fields
    first_name     VARCHAR(20),
    last_name      VARCHAR(20),
    email_address  VARCHAR(320),
    phone_number   VARCHAR(20), 
    primary key      (id)
);