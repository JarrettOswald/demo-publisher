ALTER TABLE posts
    RENAME COLUMN userid TO user_id;

ALTER TABLE posts
    ALTER COLUMN user_id TYPE bigint;