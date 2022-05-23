UPDATE teams t
SET name = 'Excelsior Qastan'
WHERE t.name = 'Excelsior FIT Group';

UPDATE teams t
SET name = 'Runa'
WHERE t.name = 'ZVC Runa';

INSERT INTO teams (name)
VALUES ('Dnweetjdathetmoeilijkwrdt'),
       ('De Zweetdieven'),
       ('Cluzona Kluisbergen');

INSERT INTO players (first_name, last_name, number)
VALUES ('Maxime', 'De Leyn', 95),
       ('Emiel', 'Deprez', 69),
       ('Behnur', 'Aliev', 97),
       ('Ruben', 'Delombaerde', 99);
