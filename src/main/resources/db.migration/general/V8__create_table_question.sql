CREATE SEQUENCE IF NOT EXISTS question_id_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE question
(
    id               BIGINT NOT NULL,
    prompt           VARCHAR(255),
    direction        VARCHAR(255),
    answer           VARCHAR(255),
    learning_task_id BIGINT,
    CONSTRAINT pk_question PRIMARY KEY (id)
);

ALTER TABLE question
    ADD CONSTRAINT FK_QUESTION_ON_LEARNINGTASK FOREIGN KEY (learning_task_id) REFERENCES learning_task (id);