CREATE SEQUENCE IF NOT EXISTS review_word_item_id_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE review_word_item
(
    id                   BIGINT NOT NULL,
    daily_word_review_id BIGINT,
    word_entry_id        BIGINT,
    word                 VARCHAR(255),
    translate            VARCHAR(255),
    CONSTRAINT pk_reviewworditem PRIMARY KEY (id)
);

ALTER TABLE review_word_item
    ADD CONSTRAINT FK_REVIEWWORDITEM_ON_DAILYWORDREVIEW FOREIGN KEY (daily_word_review_id) REFERENCES daily_word_review (id);