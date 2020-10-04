CREATE TABLE games (
    id              UUID        NOT NULL                DEFAULT uuid_generate_v4() PRIMARY KEY,
    date            DATE        NOT NULL,
    home_team_id    UUID        NOT NULL                REFERENCES teams(id),
    away_team_id    UUID        NOT NULL                REFERENCES teams(id),
    home_score      INT,
    away_score      INT
);