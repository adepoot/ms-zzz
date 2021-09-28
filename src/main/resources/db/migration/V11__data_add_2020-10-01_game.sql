INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2020-10-01', t1.id, t2.id, 3, 3
FROM teams t1, teams t2
WHERE
    t1.name = 'De Zwarte Zeverzwijnen' AND
    t2.name = 'Liquor Pool FC';

INSERT INTO game_player (game_id, player_id)
SELECT g.id, p.id FROM games g, players p
WHERE
    g.date = '2020-10-01' AND
    p.first_name IN ('Thomas', 'Rémi', 'Guillaume', 'Mathijs', 'Waut', 'Auryn', 'Victor', 'Tiebe', 'Anton');

INSERT INTO goals (game_id, scorer_id)
SELECT g.id, p.id from games g, players p
WHERE
    g.date = '2020-10-01' AND
    p.first_name = 'Rémi';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT g.id, p1.id, p2.id from games g, players p1, players p2
WHERE
    g.date = '2020-10-01' AND
    p1.first_name = 'Waut' AND
    p2.first_name IN ('Thomas', 'Tiebe');

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 12 FROM games g, players p
WHERE
    g.date = '2020-10-01' AND
    p.first_name = 'Victor';
