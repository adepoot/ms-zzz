INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2021-09-23', t1.id, t2.id, 5, 4
FROM teams t1, teams t2
WHERE
    t1.name = 'Dnweetjdathetmoeilijkwrdt' AND
    t2.name = 'De Zwarte Zeverzwijnen';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2021-09-23' AND
    p.first_name IN ('Waut', 'Victor', 'Rémi', 'Maxime', 'Tiebe', 'Guillaume', 'Mathijs');

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2021-09-23' AND
        goal.first_name = 'Waut';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-09-23' AND
        goal.first_name = 'Rémi' AND
        assist.first_name = 'Waut';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-09-23' AND
        goal.first_name = 'Waut' AND
        assist.first_name = 'Rémi';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-09-23' AND
        goal.first_name = 'Waut' AND
        assist.first_name = 'Maxime';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 7 FROM games g, players p
WHERE
    g.date = '2021-09-23' AND
    p.first_name = 'Victor';
