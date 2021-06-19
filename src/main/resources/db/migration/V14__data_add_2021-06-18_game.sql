INSERT INTO players (first_name, last_name, number)
VALUES ('Kamiel', 'Lamon', 8);

INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2021-06-18', t1.id, t2.id, 10, 6
FROM teams t1, teams t2
WHERE
    t1.name = 'Red-Side Academy' AND
    t2.name = 'De Zwarte Zeverzwijnen';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2021-06-18' AND
    p.first_name IN ('Tiebe', 'Guillame', 'Rémi', 'Waut', 'Kamiel', 'Mathijs', 'Victor');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
    game.date = '2021-06-18' AND
    goal.first_name = 'Waut' AND
    assist.first_name = 'Kamiel';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-06-18' AND
        goal.first_name = 'Rémi' AND
        assist.first_name = 'Waut';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2021-06-18' AND
        goal.first_name IN ('Waut', 'Waut', 'Waut', 'Kamiel');

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 18 FROM games g, players p
WHERE
    g.date = '2021-06-18' AND
    p.first_name = 'Victor';
