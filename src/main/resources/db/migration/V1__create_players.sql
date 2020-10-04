CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE players (
    id          UUID        NOT NULL                DEFAULT uuid_generate_v4() PRIMARY KEY,
    first_name  VARCHAR     NOT NULL,
    last_name   VARCHAR     NOT NULL,
    nickname    VARCHAR,
    number      INT,
    birthday    DATE,
    email       VARCHAR,
    created_at  TIMESTAMP WITH TIME ZONE NOT NULL   DEFAULT (now() at time zone 'utc'),
    deleted_at  TIMESTAMP WITH TIME ZONE
);