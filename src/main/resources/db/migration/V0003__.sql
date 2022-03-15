CREATE TABLE IF NOT EXISTS groups_users
(
    group_id UUID REFERENCES groups (id),
    user_id  UUID REFERENCES users (id),
    CONSTRAINT groups_users_pkey PRIMARY KEY (group_id, user_id)
);