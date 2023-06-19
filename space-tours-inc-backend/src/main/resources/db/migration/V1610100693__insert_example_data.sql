insert into orb (id, name)
values ('e690f667-3ddb-4d09-9b6b-c9dafd0d4ac6', 'Earth'),
       ('53b092cf-9bfa-4c25-981b-0c752c0bb192', 'Moon');

insert into spaceship_service (id, name, orb_id)
values ('a7534ac1-48f6-4037-aa96-8a63e253d5d0', 'Earth-LEO', 'e690f667-3ddb-4d09-9b6b-c9dafd0d4ac6'),
       ('6f6bbad0-8f48-4608-84b3-de9bc9099f37', 'Moon-LEO', '53b092cf-9bfa-4c25-981b-0c752c0bb192');

insert into spaceship_booster (id, name)
values ('a1492503-d52e-45ec-a77e-65b6dc073a81', 'Falcon 9'),
       ('4ff414f0-74cd-4c2a-8359-5d20a55a5701', 'Falcon Heavy'),
       ('46e6d091-77cb-4223-805d-9b7a08175e80', 'Atlas IV'),
       ('2fd3cb50-46c5-46cb-a060-15748a2276d1', 'Titan II');

insert into spaceship (id, name, seats, booster_id, service_id, weight_kg, max_capacity_kg, propellant_id,
                       propellant_markup)
values ('22d04993-9a97-4727-850e-0b06e1a0d848', 'Dragon', 200, 'a1492503-d52e-45ec-a77e-65b6dc073a81',
        'a7534ac1-48f6-4037-aa96-8a63e253d5d0', 549045, 22800, 1, 3),
       ('5209369e-af82-49b5-8892-0ab375c9d442', 'Big Dragon', 400, '4ff414f0-74cd-4c2a-8359-5d20a55a5701',
        'a7534ac1-48f6-4037-aa96-8a63e253d5d0', 1420788, 63800, 1, 5),
       ('aa0d00e0-a8ce-48f2-b615-b3dd313d8e48', 'Feather', 350, 'a1492503-d52e-45ec-a77e-65b6dc073a81',
        'a7534ac1-48f6-4037-aa96-8a63e253d5d0', 1104534, 45000, 3, 4),
       ('190053e9-dd8b-4ae6-a0df-f0b3e6f74643', 'New Moon', 280, '46e6d091-77cb-4223-805d-9b7a08175e80',
        '6f6bbad0-8f48-4608-84b3-de9bc9099f37', 612487, 25465, 2, 3),
       ('c53d4aed-a21f-43b4-bc10-41e5eebc35fb', 'Full Moon', 374, '2fd3cb50-46c5-46cb-a060-15748a2276d1',
        '6f6bbad0-8f48-4608-84b3-de9bc9099f37', 1242447, 57890, 1, 4);

insert into lunar_cycler (id, name)
values ('2344ed68-5d6b-48c2-ac13-98b8b133091f', 'Serenity'),
       ('5778e471-6b05-4974-9cb2-c6cf77b8dc57', 'Solaris');

insert into hotel_room (id, name, number_total, price_per_day_euro, lunar_cycler_id, orb_id)
values ('5ce643e2-51ad-11eb-ae93-0242ac130002', 'Standard', 150, 300, '2344ed68-5d6b-48c2-ac13-98b8b133091f', null),
       ('5ce6469e-51ad-11eb-ae93-0242ac130002', 'Panoramic', 80, 800, '2344ed68-5d6b-48c2-ac13-98b8b133091f', null),
       ('5ce64928-51ad-11eb-ae93-0242ac130002', '360 Penthouse', 20, 2000, '2344ed68-5d6b-48c2-ac13-98b8b133091f', null),
       ('5ce649fa-51ad-11eb-ae93-0242ac130002', 'Armstrong', 150, 300, null, '53b092cf-9bfa-4c25-981b-0c752c0bb192'),
       ('5ce64ab8-51ad-11eb-ae93-0242ac130002', 'Conrad', 80, 800, null, '53b092cf-9bfa-4c25-981b-0c752c0bb192'),
       ('5ce64d38-51ad-11eb-ae93-0242ac130002', 'Aldrin', 20, 2000, null, '53b092cf-9bfa-4c25-981b-0c752c0bb192');

insert into travel_package (id, name, departure_orb_id, spaceship_id, lunar_cycler_hotel_room_id, orb_hotel_room_id,
                            lunar_cycler_hotel_room_nights, orb_hotel_room_nights)
values ('23e3a598-51ae-11eb-ae93-0242ac130002', 'Charles Conrad space baptism', 'e690f667-3ddb-4d09-9b6b-c9dafd0d4ac6',
        '22d04993-9a97-4727-850e-0b06e1a0d848', null, null, 0, 0),
       ('23e3ac78-51ae-11eb-ae93-0242ac130002', 'Buzz Aldrin oddity', 'e690f667-3ddb-4d09-9b6b-c9dafd0d4ac6',
        '5209369e-af82-49b5-8892-0ab375c9d442', '5ce64928-51ad-11eb-ae93-0242ac130002', null, 13, 0),
       ('23e3ad90-51ae-11eb-ae93-0242ac130002', 'Neil Armstrong space explorer', 'e690f667-3ddb-4d09-9b6b-c9dafd0d4ac6',
        'aa0d00e0-a8ce-48f2-b615-b3dd313d8e48', '5ce643e2-51ad-11eb-ae93-0242ac130002',
        '5ce649fa-51ad-11eb-ae93-0242ac130002', 13, 6);

insert into booking (id, departure_date, passengers, travel_package_id)
values ('d22f3e32-1f06-4835-9ac2-9b8d6c5d5c70', '2021-01-01', 2, '23e3a598-51ae-11eb-ae93-0242ac130002'),
       ('f8bccf8e-3e86-4fd6-a99e-5d7d0e3ef9ee', '2021-01-01', 1, '23e3ac78-51ae-11eb-ae93-0242ac130002'),
       ('656190a8-3307-49b9-b308-a0da2f3abb84', '2021-01-03', 4, '23e3ad90-51ae-11eb-ae93-0242ac130002');

