CREATE SEQUENCE IF NOT EXISTS example_id_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE word_example
(
    id      BIGINT       NOT NULL,
    example VARCHAR(500) NOT NULL,
    word_id BIGINT,
    CONSTRAINT pk_wordexample PRIMARY KEY (id)
);

ALTER TABLE word_example
    ADD CONSTRAINT FK_WORDEXAMPLE_ON_WORD FOREIGN KEY (word_id) REFERENCES global_word (id);