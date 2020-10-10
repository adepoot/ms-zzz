INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2020-09-25', t1.id, t2.id, 7, 3
FROM teams t1, teams t2
WHERE
    t1.name = 'Liquor Pool FC' AND
    t2.name = 'De Zwarte Zeverzwijnen';

INSERT INTO game_player (game_id, player_id)
SELECT g.id, p.id FROM games g, players p
WHERE
    g.date = '2020-09-25' AND
    p.first_name IN ('Thomas', 'Rémi', 'Laurens', 'Mathijs', 'Waut', 'Auryn', 'Victor', 'Anton');

INSERT INTO goals (game_id, scorer_id)
SELECT g.id, p.id from games g, players p
WHERE
    g.date = '2020-09-25' AND
    p.first_name = 'Waut';

INSERT INTO goals (game_id, scorer_id)
SELECT g.id, p.id from games g, players p
WHERE
    g.date = '2020-09-25' AND
    p.first_name = 'Waut';

INSERT INTO goals (game_id, scorer_id)
SELECT g.id, p.id from games g, players p
WHERE
    g.date = '2020-09-25' AND
    p.first_name = 'Anton';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 21 FROM games g, players p
WHERE
    g.date = '2020-09-25' AND
    p.first_name = 'Victor';