CREATE SEQUENCE IF NOT EXISTS word_entry_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE word_entry
(
    id               BIGINT       NOT NULL,
    word             VARCHAR(255) NOT NULL,
    translate        VARCHAR(255) NOT NULL,
    date_added       DATE         NOT NULL,
    current_interval VARCHAR(50)  NOT NULL,
    next_review_date DATE         NOT NULL,
    user_id          BIGINT       NOT NULL,
    CONSTRAINT pk_wordentry PRIMARY KEY (id)
);