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