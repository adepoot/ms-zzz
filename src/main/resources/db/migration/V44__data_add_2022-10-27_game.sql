INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2022-10-27', t1.id, t2.id, 20, 6
FROM teams t1, teams t2
WHERE
    t1.name = 'Dnweetjdathetmoeilijkwrdt' AND
    t2.name = 'De Zwarte Zeverzwijnen';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2022-10-27' AND
    p.first_name IN ('Emiel', 'Guillaume', 'Anton', 'Auryn', 'Rémi', 'Mathijs');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-10-27' AND
        goal.first_name = 'Anton' AND
        assist.first_name = 'Guillaume';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-10-27' AND
        goal.first_name = 'Rémi' AND
        assist.first_name = 'Anton';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2022-10-27' AND
        goal.first_name = 'Emiel';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2022-10-27' AND
        goal.first_name = 'Emiel';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2022-10-27' AND
        goal.first_name = 'Anton';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2022-10-27' AND
        goal.first_name = 'Anton';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 2 FROM games g, players p
WHERE
        g.date = '2022-10-27' AND
        p.first_name = 'Auryn';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 2 FROM games g, players p
WHERE
        g.date = '2022-10-27' AND
        p.first_name = 'Rémi';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 2 FROM games g, players p
WHERE
        g.date = '2022-10-27' AND
        p.first_name = 'Guillaume';
