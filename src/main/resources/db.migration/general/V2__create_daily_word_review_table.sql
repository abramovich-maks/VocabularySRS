CREATE SEQUENCE IF NOT EXISTS daily_word_review_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE daily_word_review
(
    id        BIGINT NOT NULL,
    task_date date   NOT NULL,
    CONSTRAINT pk_dailywordreview PRIMARY KEY (id)
);