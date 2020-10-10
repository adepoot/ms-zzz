INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2020-09-16', t1.id, t2.id, 11, 3
FROM teams t1, teams t2
WHERE
    t1.name = 'ZVC Runa' AND
    t2.name = 'De Zwarte Zeverzwijnen';

INSERT INTO game_player (game_id, player_id)
SELECT g.id, p.id FROM games g, players p
WHERE
    g.date = '2020-09-16' AND
    p.first_name IN ('Thomas', 'Rémi', 'Tiebe', 'Mathijs', 'Waut', 'Auryn', 'Victor', 'Anton');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT g.id, p1.id, p2.id from games g, players p1, players p2
WHERE
    g.date = '2020-09-16' AND
    p1.first_name = 'Rémi' AND
    p2.first_name IN ('Thomas', 'Mathijs');

INSERT INTO goals (game_id, scorer_id)
SELECT g.id, p.id from games g, players p
WHERE
    g.date = '2020-09-16' AND
    p.first_name = 'Rémi';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 17 FROM games g, players p
WHERE
    g.date = '2020-09-16' AND
    p.first_name = 'Victor';