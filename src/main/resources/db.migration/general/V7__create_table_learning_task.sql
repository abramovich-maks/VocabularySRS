CREATE SEQUENCE IF NOT EXISTS learning_task_id_seq START WITH 1 INCREMENT BY 10;

CREATE TABLE learning_task
(
    id        BIGINT NOT NULL,
    task_date date,
    user_id   BIGINT,
    CONSTRAINT pk_learningtask PRIMARY KEY (id)
);