CREATE TABLE goals (
    id              UUID        NOT NULL                DEFAULT uuid_generate_v4() PRIMARY KEY,
    game_id         UUID        NOT NULL                REFERENCES games(id),
    scorer_id       UUID        NOT NULL                REFERENCES players(id),
    assister_id     UUID                                REFERENCES players(id),
    penalty         BOOLEAN
)