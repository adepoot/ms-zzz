INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2020-10-08', t1.id, t2.id, 3, 11
FROM teams t1, teams t2
WHERE
    t1.name = 'De Zwarte Zeverzwijnen' AND
    t2.name = 'Red-Side Academy';

INSERT INTO game_player (game_id, player_id)
SELECT g.id, p.id FROM games g, players p
WHERE
    g.date = '2020-10-08' AND
    p.first_name IN ('Thomas', 'Guillaume', 'Mathijs', 'Waut', 'Auryn', 'Anton');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT g.id, p1.id, p2.id from games g, players p1, players p2
WHERE
    g.date = '2020-10-08' AND
    p1.first_name = 'Waut' AND
    p2.first_name IN ('Thomas', 'Anton');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT g.id, p1.id, p2.id from games g, players p1, players p2
WHERE
    g.date = '2020-10-08' AND
    p1.first_name = 'Thomas' AND
    p2.first_name = 'Waut';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 7 FROM games g, players p
WHERE
    g.date = '2020-10-08' AND
    p.first_name = 'Anton';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 2 FROM games g, players p
WHERE
    g.date = '2020-10-08' AND
    p.first_name = 'Auryn';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 0 FROM games g, players p
WHERE
    g.date = '2020-10-08' AND
    p.first_name = 'Guillaume';
