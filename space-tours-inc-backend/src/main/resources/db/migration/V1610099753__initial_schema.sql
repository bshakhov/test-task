create table orb
(
    id   uuid primary key,
    name varchar
);

create table spaceship_service
(
    id     uuid primary key,
    name   varchar,
    orb_id uuid references orb (id) not null
);

create table spaceship_booster
(
    id   uuid primary key,
    name varchar
);

create table spaceship
(
    id                uuid primary key,
    name              varchar,
    seats             int,
    booster_id        uuid references spaceship_booster (id) not null,
    service_id        uuid references spaceship_service (id) not null,
    weight_kg         int,
    max_capacity_kg   int,
    propellant_id     int,
    propellant_markup int
);

create table lunar_cycler
(
    id   uuid primary key,
    name varchar
);

create table hotel_room
(
    id                 uuid primary key,
    name               varchar,
    number_total       int,
    price_per_day_euro int,
    lunar_cycler_id    uuid references lunar_cycler (id),
    orb_id             uuid references orb (id)
);

create table travel_package
(
    id                             uuid primary key,
    name                           varchar,
    departure_orb_id               uuid references orb (id),
    spaceship_id                   uuid references spaceship (id),
    lunar_cycler_hotel_room_id     uuid references hotel_room (id),
    orb_hotel_room_id              uuid references hotel_room (id),
    lunar_cycler_hotel_room_nights int,
    orb_hotel_room_nights          int
);

create table booking
(
    id                uuid primary key,
    departure_date    date,
    passengers        int,
    travel_package_id uuid references travel_package (id)
);
