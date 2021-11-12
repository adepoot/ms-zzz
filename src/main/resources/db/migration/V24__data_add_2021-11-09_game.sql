INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2021-11-09', t1.id, t2.id, 6, 6
FROM teams t1, teams t2
WHERE
    t1.name = 'De Zwarte Zeverzwijnen' AND
    t2.name = 'Dnweetjdathetmoeilijkwrdt';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2021-11-09' AND
    p.first_name IN ('Rémi', 'Guillaume', 'Auryn', 'Anton', 'Mathijs', 'Maxime', 'Waut');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-11-09' AND
        goal.first_name = 'Maxime' AND
        assist.first_name = 'Anton';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-11-09' AND
        goal.first_name = 'Anton' AND
        assist.first_name = 'Auryn';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-11-09' AND
        goal.first_name = 'Waut' AND
        assist.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-11-09' AND
        goal.first_name = 'Maxime' AND
        assist.first_name = 'Waut';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-11-09' AND
        goal.first_name = 'Maxime' AND
        assist.first_name = 'Waut';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2021-11-09' AND
        goal.first_name = 'Rémi';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 12 FROM games g, players p
WHERE
        g.date = '2021-11-09' AND
        p.first_name = 'Rémi';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 11 FROM games g, players p
WHERE
        g.date = '2021-11-09' AND
        p.first_name = 'Auryn';
