TRUNCATE TABLE users;
TRUNCATE TABLE trucks_categories;
TRUNCATE TABLE trucks;
TRUNCATE TABLE orders;
TRUNCATE TABLE status_history;
TRUNCATE TABLE orders_address;
TRUNCATE TABLE loads;
TRUNCATE TABLE users_has_orders;

INSERT INTO users
VALUES ('47a07384-93b8-11eb-a8b3-0242ac130003', 'Ivan', 'Ivanov', 'ivan@gmail.com', '+375331234567',
        'pass1', 'CARRIER', 'a0a81b2e-9725-11eb-a8b3-0242ac130003'),
       ('45caf4c2-9565-11eb-a8b3-0242ac130003', 'Petr', 'Petrov', 'petr@gmail.com', '+375296888258',
        'pass2', 'SHIPPER', null);

INSERT INTO trucks
VALUES ('a0a81b2e-9725-11eb-a8b3-0242ac130003', 'VOLVO', '1234VA-5', 4000, 'ALL_METAL'),
       ('886c0c76-9727-11eb-a8b3-0242ac130003', 'SCANIA', '2345AV-6', 3500, 'ALL_METAL');

INSERT INTO orders
VALUES ('377514cc-958b-11eb-a8b3-0242ac130003',
        parsedatetime('2021.01.04 11:30', 'yyyy.MM.dd hh:mm'),
        parsedatetime('2021.01.10 10:00', 'yyyy.MM.dd hh:mm'), 4000, 'ALL_METAL',
        '47a07384-93b8-11eb-a8b3-0242ac130003', '45caf4c2-9565-11eb-a8b3-0242ac130003'),

       ('3a424170-958b-11eb-a8b3-0242ac130003',
        parsedatetime('2021.02.10 12:00', 'yyyy.MM.dd hh:mm'),
        parsedatetime('2021.02.12 06:00', 'yyyy.MM.dd hh:mm'), 5000, 'ALL_METAL',
        '', '45caf4c2-9565-11eb-a8b3-0242ac130003');

INSERT INTO status_history
VALUES ('377514cc-958b-11eb-a8b3-0242ac130003', 'STARTED',
        parsedatetime('2021.01.04 11:30', 'yyyy.MM.dd hh:mm'),
        '377514cc-958b-11eb-a8b3-0242ac130003'),

       ('811f7588-96d8-11eb-a8b3-0242ac130003', 'ENDED',
        parsedatetime('2021.01.10 10:00', 'yyyy.MM.dd hh:mm'),
        '377514cc-958b-11eb-a8b3-0242ac130003');

INSERT INTO orders_address
VALUES ('a12ee7be-9589-11eb-a8b3-0242ac130003', 'HRODNO', 'MINSK',
        '377514cc-958b-11eb-a8b3-0242ac130003'),

       ('a678774e-9589-11eb-a8b3-0242ac130003', 'VITEBSK', 'BREST',
        '3a424170-958b-11eb-a8b3-0242ac130003');

INSERT INTO loads
VALUES ('5942070a-957b-11eb-a8b3-0242ac130003', 'FURNITURE', 0.5, 'Just furniture',
        '377514cc-958b-11eb-a8b3-0242ac130003'),

       ('60b523b4-957b-11eb-a8b3-0242ac130003', 'BEER', 23, 'HEINEKEN',
        '3a424170-958b-11eb-a8b3-0242ac130003');
