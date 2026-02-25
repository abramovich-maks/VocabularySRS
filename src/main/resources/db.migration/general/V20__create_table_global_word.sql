CREATE SEQUENCE IF NOT EXISTS global_words_id_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE global_word
(
    id   BIGINT       NOT NULL,
    word VARCHAR(255) NOT NULL,
    CONSTRAINT pk_globalword PRIMARY KEY (id)
);

ALTER TABLE global_word
    ADD CONSTRAINT uc_globalword_word UNIQUE (word);