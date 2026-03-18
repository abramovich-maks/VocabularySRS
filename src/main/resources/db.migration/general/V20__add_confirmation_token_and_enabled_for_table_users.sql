ALTER TABLE users
    ADD COLUMN confirmation_token VARCHAR(255);

ALTER TABLE users
    ADD COLUMN enabled BOOLEAN DEFAULT FALSE;

UPDATE users
SET enabled = TRUE;

ALTER TABLE users
    ALTER COLUMN enabled SET NOT NULL;