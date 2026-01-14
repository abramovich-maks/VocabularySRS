ALTER TABLE users
ADD COLUMN user_language VARCHAR(10) DEFAULT 'EN';

UPDATE users
SET user_language = 'EN'
WHERE user_language IS NULL;

ALTER TABLE users
ALTER COLUMN user_language SET NOT NULL;

ALTER TABLE users
ADD CONSTRAINT chk_user_language
CHECK (user_language IN ('DE', 'RU', 'PL'));
