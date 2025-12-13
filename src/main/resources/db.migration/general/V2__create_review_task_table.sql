CREATE SEQUENCE IF NOT EXISTS review_task_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE review_task
(
    id        BIGINT NOT NULL,
    task_date date,
    CONSTRAINT pk_reviewtask PRIMARY KEY (id)
);