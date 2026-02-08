CREATE SEQUENCE IF NOT EXISTS word_group_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE word_group
(
    id       BIGINT NOT NULL,
    word_id  BIGINT NOT NULL,
    group_id BIGINT NOT NULL,
    CONSTRAINT pk_word_group PRIMARY KEY (id)
);

ALTER TABLE word_group
    ADD CONSTRAINT uc_4e3b78e6bfe6389a5deed95a0 UNIQUE (word_id, group_id);

ALTER TABLE word_group
    ADD CONSTRAINT FK_WORD_GROUP_ON_GROUP FOREIGN KEY (group_id) REFERENCES groups (id);

ALTER TABLE word_group
    ADD CONSTRAINT FK_WORD_GROUP_ON_WORD FOREIGN KEY (word_id) REFERENCES word_entry (id);