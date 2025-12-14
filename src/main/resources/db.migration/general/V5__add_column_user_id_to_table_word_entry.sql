ALTER TABLE word_entry
    ADD user_id BIGINT;

ALTER TABLE word_entry
    ALTER COLUMN user_id SET NOT NULL;