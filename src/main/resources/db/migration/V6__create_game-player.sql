CREATE TABLE game_player (
    game_id         UUID        NOT NULL                REFERENCES games(id),
    player_id       UUID        NOT NULL                REFERENCES players(id)
);