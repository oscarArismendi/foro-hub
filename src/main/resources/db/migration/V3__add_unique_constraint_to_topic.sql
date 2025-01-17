-- Alter the `message` column to be VARCHAR
ALTER TABLE Topic MODIFY COLUMN message VARCHAR(500);

-- Add unique constraint to Topic table
ALTER TABLE Topic ADD CONSTRAINT unique_title_message UNIQUE (title, message);