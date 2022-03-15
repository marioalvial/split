CREATE TABLE IF NOT EXISTS groups
(
    id       UUID PRIMARY KEY,
    name     VARCHAR NOT NULL,
    owner_id UUID NOT NULL REFERENCES users (id)
);
