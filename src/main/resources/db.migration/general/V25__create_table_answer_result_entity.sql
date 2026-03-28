CREATE SEQUENCE IF NOT EXISTS answer_result_entity_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE answer_result_entity
(
    id                       BIGINT NOT NULL,
    question_id              BIGINT,
    word_id                  BIGINT,
    word                     VARCHAR(255),
    user_answer              VARCHAR(255),
    correct_answer           VARCHAR(255),
    is_correct               BOOLEAN,
    learning_test_history_id BIGINT,
    CONSTRAINT pk_answer_result_entity PRIMARY KEY (id)
);

ALTER TABLE answer_result_entity
    ADD CONSTRAINT FK_ANSWER_RESULT_ENTITY_ON_LEARNING_TEST_HISTORY FOREIGN KEY (learning_test_history_id) REFERENCES learning_test_history (id);