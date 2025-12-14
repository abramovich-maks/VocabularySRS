ALTER TABLE review_task
    ADD user_id BIGINT;

ALTER TABLE review_task
    ALTER COLUMN user_id SET NOT NULL;

ALTER TABLE review_task
    ALTER COLUMN task_date SET NOT NULL;