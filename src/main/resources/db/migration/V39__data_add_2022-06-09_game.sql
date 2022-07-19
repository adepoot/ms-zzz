INSERT INTO players (first_name, last_name, number)
VALUES ('Jamie', 'Bonte', 99);

INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2022-06-09', t1.id, t2.id, 20, 2
FROM teams t1, teams t2
WHERE
    t1.name = 'Dnweetjdathetmoeilijkwrdt' AND
    t2.name = 'De Zwarte Zeverzwijnen';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2022-06-09' AND
    p.first_name IN ('Auryn', 'Tiebe', 'Jamie', 'Guillaume', 'Anton', 'Rémi', 'Maxime');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-06-09' AND
        goal.first_name = 'Anton' AND
        assist.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2022-06-09' AND
        goal.first_name = 'Auryn';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 19 FROM games g, players p
WHERE
        g.date = '2022-06-09' AND
        p.first_name = 'Jamie';
