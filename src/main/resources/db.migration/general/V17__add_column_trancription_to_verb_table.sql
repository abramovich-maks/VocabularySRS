ALTER TABLE irregular_verb
    ADD COLUMN base_transcription VARCHAR(255) NOT NULL,
    ADD COLUMN past_transcription VARCHAR(255) NOT NULL,
    ADD COLUMN past_participle_transcription VARCHAR(255) NOT NULL;
