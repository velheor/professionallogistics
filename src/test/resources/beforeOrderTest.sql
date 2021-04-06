TRUNCATE TABLE prolog.orders;

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