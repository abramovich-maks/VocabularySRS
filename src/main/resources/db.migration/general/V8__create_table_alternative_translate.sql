CREATE SEQUENCE IF NOT EXISTS alternative_translate_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE word_details_alternative_translation
(
    id                    BIGINT       NOT NULL,
    word_details_id       BIGINT       NOT NULL,
    alternative_translate VARCHAR(255) NOT NULL,
    CONSTRAINT pk_worddetailsalternativetranslation PRIMARY KEY (id)
);

ALTER TABLE word_details_alternative_translation
    ADD CONSTRAINT FK_WORDDETAILSALTERNATIVETRANSLATION_ON_WORD_DETAILS FOREIGN KEY (word_details_id) REFERENCES word_details_entry (id);