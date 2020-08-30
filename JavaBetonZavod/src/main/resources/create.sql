drop table if exists public.purchase cascade;
drop table if exists public.buyer cascade;
drop table if exists public.seller cascade;
drop table if exists public.stairs cascade;
drop table if exists public.cocrete cascade;
drop table if exists public.roundWells cascade;
drop table if exists public.blocks cascade;

create table public.purchase (
    id serial primary key,
    date text,
    time text,
    idProduct int,
    idBuyer int,
    idSeller int,
    typeProduct text
);
create table public.Buyer (
    id int primary key,
    name text,
    address text,
    email text,
    phone_number text
);
create table public.seller (
    id int primary key,
    name text,
    phone_number text
);
create table public.stairs (
    id int primary key,
    name text,
    volume text,
    weight text,
    dimension text,
    price text,
    availability boolean,
    numberOfSteps int
);
create table public.concrete (
    id int primary key,
    name text,
    volume text,
    weight text,
    dimension text,
    price text,
    availability boolean,
    grade text
);
create table public.roundWells (
    id int primary key,
    name text,
    volume text,
    weight text,
    dimension text,
    price text,
    availability boolean,
    diameter float
);
create table public.blocks (
    id int primary key,
    name text,
    volume text,
    weight text,
    dimension text,
    price text,
    availability boolean,
    metalCarcase boolean
);
