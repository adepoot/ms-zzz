INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2022-11-21', t1.id, t2.id, 7, 1
FROM teams t1, teams t2
WHERE
    t1.name = 'Excelsior Qastan-Neerhof' AND
    t2.name = 'De Zwarte Zeverzwijnen';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2022-11-21' AND
    p.first_name IN ('Anton', 'Guillaume', 'Tiebe', 'Auryn', 'Rémi', 'Mathijs', 'Victor');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-11-21' AND
        goal.first_name = 'Auryn' AND
        assist.first_name = 'Rémi';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 14 FROM games g, players p
WHERE
        g.date = '2022-11-21' AND
        p.first_name = 'Victor';
