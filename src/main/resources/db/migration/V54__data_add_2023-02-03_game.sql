INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2023-02-03', t1.id, t2.id, 3, 1
FROM teams t1, teams t2
WHERE
    t1.name = 'Cluzona Kluisbergen' AND
    t2.name = 'De Zwarte Zeverzwijnen';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2023-02-03' AND
    p.first_name IN ('Anton', 'Auryn', 'Guillaume', 'Maxime', 'Tiebe', 'Victor');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-02-03' AND
        goal.first_name = 'Anton' AND
        assist.first_name = 'Maxime';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 13 FROM games g, players p
WHERE
        g.date = '2023-02-03' AND
        p.first_name = 'Victor';
