INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2023-03-13', t1.id, t2.id, 13, 6
FROM teams t1, teams t2
WHERE
    t1.name = 'De Zwarte Zeverzwijnen' AND
    t2.name = 'Hangover ''96';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2023-03-13' AND
    p.first_name IN ('Anton', 'Auryn', 'Behnur', 'Guillaume', 'Behnur', 'Christophe', 'Maxime');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-03-13' AND
        goal.first_name = 'Behnur' AND
        assist.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-03-13' AND
        goal.first_name = 'Behnur' AND
        assist.first_name = 'Guillaume';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-03-13' AND
        goal.first_name = 'Behnur' AND
        assist.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-03-13' AND
        goal.first_name = 'Behnur' AND
        assist.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-03-13' AND
        goal.first_name = 'Behnur' AND
        assist.first_name = 'Anton';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-03-13' AND
        goal.first_name = 'Guillaume' AND
        assist.first_name = 'Christophe';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-03-13' AND
        goal.first_name = 'Maxime' AND
        assist.first_name = 'Behnur';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-03-13' AND
        goal.first_name = 'Christophe' AND
        assist.first_name = 'Anton';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-03-13' AND
        goal.first_name = 'Christophe' AND
        assist.first_name = 'Behnur';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2023-03-13' AND
        goal.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2023-03-13' AND
        goal.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2023-03-13' AND
        goal.first_name = 'Christophe';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2023-03-13' AND
        goal.first_name = 'Christophe';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 3 FROM games g, players p
WHERE
        g.date = '2023-03-13' AND
        p.first_name = 'Tiebe';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 3 FROM games g, players p
WHERE
        g.date = '2023-03-13' AND
        p.first_name = 'Auryn';
