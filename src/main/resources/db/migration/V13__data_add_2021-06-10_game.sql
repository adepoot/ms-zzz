INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2021-06-10', t1.id, t2.id, 3, 11
FROM teams t1, teams t2
WHERE
    t1.name = 'De Zwarte Zeverzwijnen' AND
    t2.name = 'ZVC Leie Shotters';

INSERT INTO game_player (game_id, player_id)
SELECT g.id, p.id FROM games g, players p
WHERE
    g.date = '2021-06-10' AND
    p.first_name IN ('Tiebe', 'Guillame', 'Rémi', 'Waut', 'Auryn', 'Anton', 'Victor');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT g.id, p1.id, p2.id from games g, players p1, players p2
WHERE
    g.date = '2021-06-10' AND
    p1.first_name = 'Waut' AND
    p2.first_name = 'Guillame';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT g.id, p1.id, p2.id from games g, players p1, players p2
WHERE
        g.date = '2021-06-10' AND
        p1.first_name = 'Rémi' AND
        p2.first_name = 'Anton';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT g.id, p1.id, p2.id from games g, players p1, players p2
WHERE
        g.date = '2021-06-10' AND
        p1.first_name = 'Auryn' AND
        p2.first_name = 'Rémi';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT g.id, p1.id, p2.id from games g, players p1, players p2
WHERE
        g.date = '2021-06-10' AND
        p1.first_name = 'Anton' AND
        p2.first_name = 'Tiebe';

INSERT INTO goals (game_id, scorer_id)
SELECT g.id, p1.id from games g, players p1
WHERE
        g.date = '2021-06-10' AND
        p1.first_name IN ('Waut', 'Rémi');

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 11 FROM games g, players p
WHERE
    g.date = '2021-06-10' AND
    p.first_name = 'Victor';
