UPDATE teams t
SET name = 'Excelsior Qastan'
WHERE t.name = 'Excelsior FIT Group';

UPDATE teams t
SET name = 'ZVC Runa'
WHERE t.name = 'Runa';

INSERT INTO teams (name)
VALUES ('Dnweetjdathetmoeilijkwrdt'),
       ('ZVC Leie Shotters'),
       ('De Zweetdieven'),
       ('Cluzona Kluisbergen');

UPDATE players p
SET number = 13
WHERE p.first_name = 'Victor';

UPDATE players p
SET number = 5
WHERE p.first_name = 'Tiebe';

INSERT INTO players (first_name, last_name, number)
VALUES ('Maxime', 'De Leyn', 74),
       ('Emiel', 'Deprez', 69);

