TRUNCATE TABLE prolog.users;
TRUNCATE TABLE prolog.trucks_categories;
TRUNCATE TABLE prolog.trucks;
TRUNCATE TABLE prolog.orders;
TRUNCATE TABLE prolog.status_history;
TRUNCATE TABLE prolog.orders_address;
TRUNCATE TABLE prolog.loads;
TRUNCATE TABLE prolog.users_has_orders;

INSERT INTO prolog.users
VALUES ('47a07384-93b8-11eb-a8b3-0242ac130003', 'Ivan', 'Ivanov', 'ivan@gmail.com', '+375331234567',
        'pass1', 'CARRIER', 'a0a81b2e-9725-11eb-a8b3-0242ac130003'),
       ('45caf4c2-9565-11eb-a8b3-0242ac130003', 'Petr', 'Petrov', 'petr@gmail.com', '+375296888258',
        'pass2', 'CARRIER', null);

INSERT INTO prolog.trucks_categories
VALUES (0, 'COVERED', null),
       (1, 'ALL-METAL', 0);

INSERT INTO prolog.trucks
VALUES ('a0a81b2e-9725-11eb-a8b3-0242ac130003', 'VOLVO', '1234VA-5', 10, 1),
       ('886c0c76-9727-11eb-a8b3-0242ac130003', 'SCANIA', '2345AV-6', 11, 1);

INSERT INTO prolog.orders
VALUES ('377514cc-958b-11eb-a8b3-0242ac130003',
        parsedatetime('2021.01.04 11:30', 'yyyy.MM.dd hh:mm'),
        parsedatetime('2021.01.10 10:00', 'yyyy.MM.dd hh:mm'), 4000, ''),

       ('3a424170-958b-11eb-a8b3-0242ac130003',
        parsedatetime('2021.02.10 12:00', 'yyyy.MM.dd hh:mm'),
        parsedatetime('2021.02.12 06:00', 'yyyy.MM.dd hh:mm'), 5000, '');

INSERT INTO prolog.status_history
VALUES ('377514cc-958b-11eb-a8b3-0242ac130003', 'STARTED',
        parsedatetime('2021.01.04 11:30', 'yyyy.MM.dd hh:mm'),
        '377514cc-958b-11eb-a8b3-0242ac130003'),

       ('811f7588-96d8-11eb-a8b3-0242ac130003', 'ENDED',
        parsedatetime('2021.01.10 10:00', 'yyyy.MM.dd hh:mm'),
        '377514cc-958b-11eb-a8b3-0242ac130003');

INSERT INTO prolog.orders_address
VALUES ('a12ee7be-9589-11eb-a8b3-0242ac130003', 'HRODNO', 'MINSK',
        '377514cc-958b-11eb-a8b3-0242ac130003'),

       ('a678774e-9589-11eb-a8b3-0242ac130003', 'VITEBSK', 'BREST',
        '3a424170-958b-11eb-a8b3-0242ac130003');

INSERT INTO prolog.loads
VALUES ('5942070a-957b-11eb-a8b3-0242ac130003', 'FURNITURE', 0.5, 'Just furniture',
        '377514cc-958b-11eb-a8b3-0242ac130003'),

       ('60b523b4-957b-11eb-a8b3-0242ac130003', 'BEER', 23, 'HEINEKEN',
        '3a424170-958b-11eb-a8b3-0242ac130003');
