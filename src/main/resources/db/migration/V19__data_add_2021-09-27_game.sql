INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2021-09-27', t1.id, t2.id, 4, 4
FROM teams t1, teams t2
WHERE
    t1.name = 'Excelsior Qastan' AND
    t2.name = 'De Zwarte Zeverzwijnen';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2021-09-27' AND
    p.first_name IN ('Victor', 'Rémi', 'Emiel', 'Guillaume', 'Tiebe', 'Anton');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-09-27' AND
        goal.first_name = 'Emiel' AND
        assist.first_name = 'Guillaume';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-09-27' AND
        goal.first_name = 'Emiel' AND
        assist.first_name = 'Guillaume';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2021-09-27' AND
        goal.first_name = 'Emiel' AND
        assist.first_name = 'Anton';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 12 FROM games g, players p
WHERE
    g.date = '2021-09-27' AND
    p.first_name = 'Victor';
