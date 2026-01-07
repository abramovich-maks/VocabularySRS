CREATE SEQUENCE IF NOT EXISTS word_details_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE word_details_entry
(
    id             BIGINT NOT NULL,
    word_id        BIGINT,
    user_id        BIGINT,
    phonetic       VARCHAR(255),
    audio_url      VARCHAR(255),
    part_of_speech VARCHAR(255),
    definition     VARCHAR(1000),
    example        VARCHAR(1000),
    CONSTRAINT pk_worddetailsentry PRIMARY KEY (id)
);