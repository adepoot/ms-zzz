INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2023-04-16', t1.id, t2.id, 5, 11
FROM teams t1, teams t2
WHERE
    t1.name = 'KdNS Heule' AND
    t2.name = 'De Zwarte Zeverzwijnen';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2023-04-16' AND
    p.first_name IN ('Ruben', 'Emiel', 'Mathijs', 'Maxime', 'Tiebe', 'Victor', 'Guillaume');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-04-16' AND
        goal.first_name = 'Ruben' AND
        assist.first_name = 'Mathijs';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-04-16' AND
        goal.first_name = 'Ruben' AND
        assist.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-04-16' AND
        goal.first_name = 'Emiel' AND
        assist.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-04-16' AND
        goal.first_name = 'Maxime' AND
        assist.first_name = 'Ruben';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-04-16' AND
        goal.first_name = 'Emiel' AND
        assist.first_name = 'Ruben';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-04-16' AND
        goal.first_name = 'Tiebe' AND
        assist.first_name = 'Emiel';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-04-16' AND
        goal.first_name = 'Maxime' AND
        assist.first_name = 'Mathijs';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-04-16' AND
        goal.first_name = 'Maxime' AND
        assist.first_name = 'Emiel';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-04-16' AND
        goal.first_name = 'Guillaume' AND
        assist.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2023-04-16' AND
        goal.first_name = 'Emiel';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2023-04-16' AND
        goal.first_name = 'Ruben';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 21 FROM games g, players p
WHERE
        g.date = '2023-04-16' AND
        p.first_name = 'Victor';
