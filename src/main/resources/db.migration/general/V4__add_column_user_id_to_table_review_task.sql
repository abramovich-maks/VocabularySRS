ALTER TABLE daily_word_review
    ADD user_id BIGINT;

ALTER TABLE daily_word_review
    ALTER COLUMN user_id SET NOT NULL;

ALTER TABLE daily_word_review
    ALTER COLUMN task_date SET NOT NULL;