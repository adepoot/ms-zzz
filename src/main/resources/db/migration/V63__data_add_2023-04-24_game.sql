INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2023-04-24', t1.id, t2.id, 9, 1
FROM teams t1, teams t2
WHERE
    t1.name = 'Hangover ''96' AND
    t2.name = 'De Zwarte Zeverzwijnen';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2023-04-24' AND
    p.first_name IN ('Victor', 'Tiebe', 'Auryn', 'Guillaume', 'Ruben', 'Maxime', 'Dante');

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 6 FROM games g, players p
WHERE
        g.date = '2023-04-24' AND
        p.first_name = 'Victor';
