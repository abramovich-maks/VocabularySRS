CREATE SEQUENCE IF NOT EXISTS word_entry_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE word_entry
(
    id               BIGINT       NOT NULL,
    word             VARCHAR(255) NOT NULL,
    translate        VARCHAR(255) NOT NULL,
    date_added       date         NOT NULL,
    current_interval VARCHAR(255),
    next_review_date date,
    CONSTRAINT pk_wordentry PRIMARY KEY (id)
);