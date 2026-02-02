ALTER TABLE word_entry
    ADD group_id BIGINT;

ALTER TABLE word_entry
    ADD CONSTRAINT FK_WORDENTRY_ON_GROUP FOREIGN KEY (group_id) REFERENCES words_group (id);