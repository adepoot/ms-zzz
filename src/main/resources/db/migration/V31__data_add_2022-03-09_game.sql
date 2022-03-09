INSERT INTO games (date, home_team_id, away_team_id, home_score, away_score)
SELECT '2022-03-09', t1.id, t2.id, 8, 7
FROM teams t1, teams t2
WHERE
    t1.name = 'De Zwarte Zeverzwijnen' AND
    t2.name = 'ZVC Leie Shotters';

INSERT INTO game_player (game_id, player_id)
SELECT game.id, p.id FROM games game, players p
WHERE
    game.date = '2022-03-09' AND
    p.first_name IN ('Mathijs', 'Guillaume', 'Auryn', 'Anton', 'Victor', 'Maxime', 'Rémi');

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-03-09' AND
        goal.first_name = 'Rémi' AND
        assist.first_name = 'Victor';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-03-09' AND
        goal.first_name = 'Anton' AND
        assist.first_name = 'Rémi';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-03-09' AND
        goal.first_name = 'Rémi' AND
        assist.first_name = 'Anton';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-03-09' AND
        goal.first_name = 'Guillaume' AND
        assist.first_name = 'Anton';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-03-09' AND
        goal.first_name = 'Maxime' AND
        assist.first_name = 'Victor';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-03-09' AND
        goal.first_name = 'Anton' AND
        assist.first_name = 'Maxime';

INSERT INTO goals (game_id, scorer_id, assister_id)
SELECT game.id, goal.id, assist.id from games game,players goal,players assist
WHERE
        game.date = '2022-03-09' AND
        goal.first_name = 'Maxime' AND
        assist.first_name = 'Rémi';

INSERT INTO goals (game_id, scorer_id)
SELECT game.id, goal.id from games game, players goal
WHERE
        game.date = '2022-03-09' AND
        goal.first_name = 'Rémi';

INSERT INTO saves (game_id, player_id, count)
SELECT g.id, p.id, 18 FROM games g, players p
WHERE
        g.date = '2022-03-09' AND
        p.first_name = 'Victor';
