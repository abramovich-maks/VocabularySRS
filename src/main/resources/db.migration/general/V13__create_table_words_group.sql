CREATE SEQUENCE IF NOT EXISTS group_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE groups
(
    id         BIGINT      NOT NULL,
    user_id    BIGINT      NOT NULL,
    group_name VARCHAR(25) NOT NULL,
    CONSTRAINT pk_wordsgroup PRIMARY KEY (id)
);