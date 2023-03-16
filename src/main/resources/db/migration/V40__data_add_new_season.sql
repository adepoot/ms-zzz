UPDATE teams t
SET name = 'Excelsior Qastan-Neerhof'
WHERE t.name = 'Excelsior Qastan';

INSERT INTO teams (name)
VALUES ('De Voetbalduiven'),
       ('Hangover ''96'),
       ('KdNS Heule');

INSERT INTO players (first_name, last_name, number)
VALUES ('Christophe', 'Bostyn', 99);
