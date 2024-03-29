INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2022-04-12', t1.id, t2.id, 3, 8
FROM teams t1, teams t2
WHERE
    t1.name = 'De Zwarte Zeverzwijnen' AND
    t2.name = 'Celtic Glasvol';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2022-04-12' AND
    p.first_name IN ('Victor', 'Tiebe', 'Auryn', 'Mathijs', 'Maxime');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-04-12' AND
        goal.first_name = 'Auryn' AND
        assist.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-04-12' AND
        goal.first_name = 'Auryn' AND
        assist.first_name = 'Tiebe';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-04-12' AND
        goal.first_name = 'Maxime' AND
        assist.first_name = 'Mathijs';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 19 FROM games g, players p
WHERE
        g.date = '2022-04-12' AND
        p.first_name = 'Victor';
