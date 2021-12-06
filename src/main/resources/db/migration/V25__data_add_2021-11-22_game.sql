INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2021-11-22', t1.id, t2.id, 4, 7
FROM teams t1, teams t2
WHERE
    t1.name = 'ZVC Leie Shotters' AND
    t2.name = 'De Zwarte Zeverzwijnen';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2021-11-22' AND
    p.first_name IN ('Rémi', 'Guillaume', 'Auryn', 'Anton', 'Behnur', 'Tiebe', 'Emiel');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-11-22' AND
        goal.first_name = 'Behnur' AND
        assist.first_name = 'Emiel';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-11-22' AND
        goal.first_name = 'Tiebe' AND
        assist.first_name = 'Emiel';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-11-22' AND
        goal.first_name = 'Anton' AND
        assist.first_name = 'Tiebe';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-11-22' AND
        goal.first_name = 'Rémi' AND
        assist.first_name = 'Tiebe';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2021-11-22' AND
        goal.first_name = 'Emiel';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2021-11-22' AND
        goal.first_name = 'Emiel';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2021-11-22' AND
        goal.first_name = 'Emiel';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 6 FROM games g, players p
WHERE
        g.date = '2021-11-22' AND
        p.first_name = 'Rémi';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 6 FROM games g, players p
WHERE
        g.date = '2021-11-22' AND
        p.first_name = 'Auryn';
