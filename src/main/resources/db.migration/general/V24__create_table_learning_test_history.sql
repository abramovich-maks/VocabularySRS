CREATE SEQUENCE IF NOT EXISTS learning_test_history_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE learning_test_history
(
    id                BIGINT NOT NULL,
    user_id           BIGINT NOT NULL,
    test_date         date,
    total_questions   INTEGER,
    correct_answers   INTEGER,
    incorrect_answers INTEGER,
    CONSTRAINT pk_learning_test_history PRIMARY KEY (id)
);

ALTER TABLE learning_test_history
    ADD CONSTRAINT FK_LEARNING_TEST_HISTORY_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);