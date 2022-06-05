CREATE TABLE posts
(
    id           int generated always as identity PRIMARY KEY,
    publish_date date,
    userId       int,
    title        varchar,
    body         text
);