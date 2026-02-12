CREATE SEQUENCE IF NOT EXISTS irregular_verb_translation_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE irregular_verb_translation
(
    id          BIGINT       NOT NULL,
    language    VARCHAR(10)  NOT NULL,
    translation VARCHAR(255) NOT NULL,
    verb_id     BIGINT       NOT NULL,
    CONSTRAINT pk_irregularverbtranslation PRIMARY KEY (id),
    CONSTRAINT uk_verb_language UNIQUE (verb_id, language),
    CONSTRAINT fk_irregularverbtranslation_on_verb
        FOREIGN KEY (verb_id) REFERENCES irregular_verb (id)
);
