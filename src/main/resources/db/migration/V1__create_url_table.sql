CREATE TABLE url
(
    hash VARCHAR(8) NOT NULL,
    origin_url VARCHAR NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    expiration_date TIMESTAMP NOT NULL,
    PRIMARY KEY (hash)
);

