INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2022-05-03', t1.id, t2.id, 7, 3
FROM teams t1, teams t2
WHERE
    t1.name = 'Cluzona Kluisbergen' AND
    t2.name = 'De Zwarte Zeverzwijnen';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2022-05-03' AND
    p.first_name IN ('Rémi', 'Auryn', 'Mathijs', 'Tiebe', 'Maxime', 'Guillaume', 'Anton');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-05-03' AND
        goal.first_name = 'Auryn' AND
        assist.first_name = 'Anton';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-05-03' AND
        goal.first_name = 'Auryn' AND
        assist.first_name = 'Tiebe';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-05-03' AND
        goal.first_name = 'Maxime' AND
        assist.first_name = 'Tiebe';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2022-05-03' AND
        goal.first_name = 'Emiel';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 9 FROM games g, players p
WHERE
        g.date = '2022-05-03' AND
        p.first_name = 'Tiebe';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 5 FROM games g, players p
WHERE
        g.date = '2022-05-03' AND
        p.first_name = 'Auryn';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 2 FROM games g, players p
WHERE
        g.date = '2022-05-03' AND
        p.first_name = 'Rémi';
