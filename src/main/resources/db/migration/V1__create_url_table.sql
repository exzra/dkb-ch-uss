CREATE TABLE url
(
    hash VARCHAR(16) NOT NULL,
    origin_url VARCHAR NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    expirationDate TIMESTAMP NOT NULL,
    PRIMARY KEY (hash)
);

