CREATE TABLE IF NOT EXISTS resorts (
    slug VARCHAR(255) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    region VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL);