INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2022-05-24', t1.id, t2.id, 5, 4
FROM teams t1, teams t2
WHERE
    t1.name = 'De Zwarte Zeverzwijnen' AND
    t2.name = 'Runa';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2022-05-24' AND
    p.first_name IN ('Auryn', 'Mathijs', 'Tiebe', 'Victor', 'Guillaume', 'Anton', 'Rémi', 'Maxime');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-05-24' AND
        goal.first_name = 'Auryn' AND
        assist.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-05-24' AND
        goal.first_name = 'Rémi' AND
        assist.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-05-24' AND
        goal.first_name = 'Auryn' AND
        assist.first_name = 'Guillaume';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-05-24' AND
        goal.first_name = 'Maxime' AND
        assist.first_name = 'Tiebe';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-05-24' AND
        goal.first_name = 'Maxime' AND
        assist.first_name = 'Guillaume';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 18 FROM games g, players p
WHERE
        g.date = '2022-05-24' AND
        p.first_name = 'Victor';
