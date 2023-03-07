INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2023-02-20', t1.id, t2.id, 2, 6
FROM teams t1, teams t2
WHERE
    t1.name = 'De Zwarte Zeverzwijnen' AND
    t2.name = 'Dnweetjdathetmoeilijkwrdt';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2023-02-20' AND
    p.first_name IN ('Anton', 'Auryn', 'Emiel', 'Mathijs', 'Tiebe', 'Victor', 'Ruben');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2023-02-20' AND
        goal.first_name = 'Auryn' AND
        assist.first_name = 'Tiebe';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2023-02-20' AND
        goal.first_name = 'Emiel';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 17 FROM games g, players p
WHERE
        g.date = '2023-02-20' AND
        p.first_name = 'Victor';
