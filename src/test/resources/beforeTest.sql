TRUNCATE TABLE users;
TRUNCATE TABLE trucks;
TRUNCATE TABLE orders;
TRUNCATE TABLE statuses;
TRUNCATE TABLE addresses;
TRUNCATE TABLE loads;
TRUNCATE TABLE routes;
TRUNCATE TABLE roles;

INSERT INTO users
VALUES ('47a07384-93b8-11eb-a8b3-0242ac130003', 'Test1', 'Test1', 'test1@gmail.com',
        '+375 (33) 123-45-67',
        '$2y$12$yVeTM63pz0oSJeet.BGEU.GxJvJdnf0FX5rGcqGl4Mk51edhBa1SC'),
       ('45caf4c2-9565-11eb-a8b3-0242ac130003', 'Test2', 'Test2', 'test2@gmail.com',
        '+375 (33) 111-22-33',
        '$2y$12$ZN3OaMsgVkx9Z6.b.tnHSeok9zxUSVtQH9A0JFxSEhW8son/POBXi');

INSERT INTO trucks
VALUES ('2da16836-9c4a-11eb-a8b3-0242ac130003', 'VOLVO', '1234VA-5', 4000, 'ALL_METAL',
        '47a07384-93b8-11eb-a8b3-0242ac130003'),
       ('365e1fdc-9c4a-11eb-a8b3-0242ac130003', 'SCANIA', '2345AV-6', 3500, 'ALL_METAL', null);

INSERT INTO roles
values ('cd2d4abe-9c4a-11eb-a8b3-0242ac130003', 'CARRIER', '47a07384-93b8-11eb-a8b3-0242ac130003'),
       ('faf2d93a-9c4c-11eb-a8b3-0242ac130003', 'SHIPPER', '45caf4c2-9565-11eb-a8b3-0242ac130003');

INSERT INTO orders
VALUES ('377514cc-958b-11eb-a8b3-0242ac130003',
        parsedatetime('2021.01.04 11:30', 'yyyy.MM.dd hh:mm'),
        parsedatetime('2021.01.10 10:00', 'yyyy.MM.dd hh:mm'), null, null, 4000, 'ALL_METAL',
        '47a07384-93b8-11eb-a8b3-0242ac130003',
        '45caf4c2-9565-11eb-a8b3-0242ac130003'),

       ('3a424170-958b-11eb-a8b3-0242ac130003',
        parsedatetime('2021.02.10 11:00', 'yyyy.MM.dd hh:mm'),
        parsedatetime('2021.02.12 06:00', 'yyyy.MM.dd hh:mm'), null, null, 5000, 'ALL_METAL', null,
        '45caf4c2-9565-11eb-a8b3-0242ac130003');

INSERT INTO loads
VALUES ('5942070a-957b-11eb-a8b3-0242ac130003', 'FURNITURE', 0.5, 'Just furniture',
        '377514cc-958b-11eb-a8b3-0242ac130003'),

       ('60b523b4-957b-11eb-a8b3-0242ac130003', 'BEER', 23, 'HEINEKEN',
        '3a424170-958b-11eb-a8b3-0242ac130003');

INSERT INTO statuses
VALUES ('377514cc-958b-11eb-a8b3-0242ac130003', 'WAITING_FOR_CARRIER',
        parsedatetime('2021.01.03 11:30', 'yyyy.MM.dd hh:mm'),
        '377514cc-958b-11eb-a8b3-0242ac130003'),

       ('811f7588-96d8-11eb-a8b3-0242ac130003', 'WAITING_FOR_LOADING',
        parsedatetime('2021.01.03 11:45', 'yyyy.MM.dd hh:mm'),
        '377514cc-958b-11eb-a8b3-0242ac130003');

INSERT INTO addresses
VALUES ('fe8866ce-9c4b-11eb-a8b3-0242ac130003', 'BELARUS', 'HRODNO', 'STREET', '1337-A'),
       ('446d6234-9c4c-11eb-a8b3-0242ac130003', 'BELARUS', 'MINSK', 'STREETS', '1373-B');

INSERT INTO routes
VALUES ('6db382c2-9c4c-11eb-a8b3-0242ac130003', '377514cc-958b-11eb-a8b3-0242ac130003',
        'fe8866ce-9c4b-11eb-a8b3-0242ac130003',
        '446d6234-9c4c-11eb-a8b3-0242ac130003'),

       ('38aea24a-9c4d-11eb-a8b3-0242ac130003', '3a424170-958b-11eb-a8b3-0242ac130003',
        'fe8866ce-9c4b-11eb-a8b3-0242ac130003',
        '446d6234-9c4c-11eb-a8b3-0242ac130003');