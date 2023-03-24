-- Postgres
--CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- H2
CREATE ALIAS uuid_generate_v4 AS '
    UUID ez_uuid() {
        return UUID.randomUUID();
    }
';

CREATE TABLE players (
    id          UUID        NOT NULL                DEFAULT uuid_generate_v4() PRIMARY KEY,
    first_name  VARCHAR     NOT NULL,
    last_name   VARCHAR     NOT NULL,
    nickname    VARCHAR,
    number      INT,
    birthday    DATE,
    email       VARCHAR,
    -- Postgres
    --created_at  TIMESTAMP WITH TIME ZONE NOT NULL   DEFAULT (now() at time zone 'utc'),
    -- H2
    created_at  TIMESTAMP WITH TIME ZONE NOT NULL   DEFAULT now(),
    deleted_at  TIMESTAMP WITH TIME ZONE
);
