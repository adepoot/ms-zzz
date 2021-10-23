INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2021-10-19', t1.id, t2.id, 6, 9
FROM teams t1, teams t2
WHERE
    t1.name = 'Cluzona Kluisbergen' AND
    t2.name = 'De Zwarte Zeverzwijnen';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2021-10-19' AND
    p.first_name IN ('Victor', 'Guillaume', 'Auryn', 'Emiel', 'Mathijs', 'Maxime');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-10-19' AND
        goal.first_name = 'Maxime' AND
        assist.first_name = 'Victor';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-10-19' AND
        goal.first_name = 'Maxime' AND
        assist.first_name = 'Guillaume';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-10-19' AND
        goal.first_name = 'Emiel' AND
        assist.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2021-10-19' AND
        goal.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2021-10-19' AND
        goal.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2021-10-19' AND
        goal.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2021-10-19' AND
        goal.first_name = 'Emiel';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2021-10-19' AND
        goal.first_name = 'Mathijs';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2021-10-19' AND
        goal.first_name = 'Auryn';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 11 FROM games g, players p
WHERE
    g.date = '2021-10-19' AND
    p.first_name = 'Victor';
