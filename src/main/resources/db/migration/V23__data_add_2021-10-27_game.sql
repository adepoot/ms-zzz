INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2021-10-27', t1.id, t2.id, 7, 5
FROM teams t1, teams t2
WHERE
    t1.name = 'Runa' AND
    t2.name = 'De Zwarte Zeverzwijnen';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2021-10-27' AND
    p.first_name IN ('Rémi', 'Guillaume', 'Auryn', 'Anton', 'Mathijs', 'Maxime', 'Tiebe', 'Waut');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-10-27' AND
        goal.first_name = 'Mathijs' AND
        assist.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-10-27' AND
        goal.first_name = 'Anton' AND
        assist.first_name = 'Tiebe';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-10-27' AND
        goal.first_name = 'Tiebe' AND
        assist.first_name = 'Waut';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2021-10-27' AND
        goal.first_name = 'Waut';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2021-10-27' AND
        goal.first_name = 'Waut';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 14 FROM games g, players p
WHERE
        g.date = '2021-10-27' AND
        p.first_name = 'Rémi';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 7 FROM games g, players p
WHERE
        g.date = '2021-10-27' AND
        p.first_name = 'Anton';
