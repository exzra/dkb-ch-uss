CREATE TABLE url
(
    hash VARCHAR2(16) NOT NULL,
    origin_url VARCHAR2 NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    expirationDate TIMESTAMP NOT NULL,
    PRIMARY KEY (hash)
);

