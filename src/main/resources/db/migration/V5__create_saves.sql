CREATE TABLE saves (
    id              UUID        NOT NULL                DEFAULT uuid_generate_v4() PRIMARY KEY,
    game_id         UUID        NOT NULL                REFERENCES games(id),
    player_id       UUID        NOT NULL                REFERENCES players(id),
    count           INT         NOT NULL
)