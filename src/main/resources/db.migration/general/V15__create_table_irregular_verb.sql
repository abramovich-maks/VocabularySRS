CREATE SEQUENCE IF NOT EXISTS irregular_verb_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE irregular_verb
(
    id              BIGINT       NOT NULL,
    base_form       VARCHAR(255) NOT NULL,
    past_simple     VARCHAR(255) NOT NULL,
    past_participle VARCHAR(255) NOT NULL,
    CONSTRAINT pk_irregularverb PRIMARY KEY (id),
    CONSTRAINT uk_irregular_verb_base UNIQUE (base_form)
);
