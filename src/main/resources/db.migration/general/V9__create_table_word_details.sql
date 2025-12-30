CREATE TABLE word_details_entry
(
    word_entry_id  BIGINT NOT NULL,
    phonetic       VARCHAR(255),
    audio_url      VARCHAR(255),
    part_of_speech VARCHAR(255),
    definition     VARCHAR(1000),
    example        VARCHAR(1000),
    CONSTRAINT pk_worddetailsentry PRIMARY KEY (word_entry_id)
);

ALTER TABLE word_details_entry
    ADD CONSTRAINT FK_WORDDETAILSENTRY_ON_WORDENTRY FOREIGN KEY (word_entry_id) REFERENCES word_entry (id);