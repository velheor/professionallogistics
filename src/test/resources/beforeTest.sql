TRUNCATE TABLE prolog.users;
TRUNCATE TABLE prolog.trucks_categories;
TRUNCATE TABLE prolog.trucks;
TRUNCATE TABLE prolog.orders;
TRUNCATE TABLE prolog.status_history;
TRUNCATE TABLE prolog.orders_address;
TRUNCATE TABLE prolog.loads;

INSERT INTO prolog.users
VALUES ('47a07384-93b8-11eb-a8b3-0242ac130003', 'Ivan', 'Ivanov', 'ivan@gmail.com', '+375331234567',
        'pass1', 'CARRIER'),
       ('45caf4c2-9565-11eb-a8b3-0242ac130003', 'Petr', 'Petrov', 'petr@gmail.com', '+375296888258',
        'pass2', 'SHIPPER');

INSERT INTO prolog.trucks_categories
VALUES (0, 'COVERED', null),
       (1, 'OPEN', null),
       (2, 'SPECIAL', null),
       (3, 'AWNING', 0),
       (4, 'CURTAIN', 0),
       (5, 'ALL-METAL', 0),
       (6, 'ONBOARD', 1),
       (7, 'OVERSIZED', 1),
       (8, 'DUMP', 1),
       (9, 'WOOD', 2),
       (10, 'TANKER', 2);

INSERT INTO prolog.trucks
VALUES ('47a07384-93b8-11eb-a8b3-0242ac130003', 'VOLVO', '1234VA-5', 10, 4),
       ('45caf4c2-9565-11eb-a8b3-0242ac130003', 'MAN', '4171AK-4', 20, 5);

INSERT INTO prolog.orders
VALUES ('377514cc-958b-11eb-a8b3-0242ac130003',
        parsedatetime('2021.01.04 11:30', 'yyyy.MM.dd hh:mm'),
        parsedatetime('2021.01.10 10:00', 'yyyy.MM.dd hh:mm'), 4000, ''),

       ('3a424170-958b-11eb-a8b3-0242ac130003',
        parsedatetime('2021.02.10 12:00', 'yyyy.MM.dd hh:mm'),
        parsedatetime('2021.02.12 06:00', 'yyyy.MM.dd hh:mm'), 5000, ''),

       ('3d19295e-958b-11eb-a8b3-0242ac130003',
        parsedatetime('2021.03.05 15:00', 'yyyy.MM.dd hh:mm'),
        parsedatetime('2021.03.06 19:30', 'yyyy.MM.dd hh:mm'), 1400, '');

INSERT INTO prolog.status_history
VALUES ('377514cc-958b-11eb-a8b3-0242ac130003', 'STARTED',
        parsedatetime('2021.01.04 11:30', 'yyyy.MM.dd hh:mm'), '377514cc-958b-11eb-a8b3-0242ac130003'),

       ('811f7588-96d8-11eb-a8b3-0242ac130003', 'ENDED',
        parsedatetime('2021.01.10 10:00', 'yyyy.MM.dd hh:mm'), '377514cc-958b-11eb-a8b3-0242ac130003');

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

