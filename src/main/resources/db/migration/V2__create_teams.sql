CREATE TABLE teams (
    id                  UUID        NOT NULL                DEFAULT uuid_generate_v4() PRIMARY KEY,
    name                VARCHAR     NOT NULL,
    address_country     VARCHAR,
    address_city        VARCHAR,
    address_zipcode     VARCHAR,
    address_street      VARCHAR,
    address_number      INT
);