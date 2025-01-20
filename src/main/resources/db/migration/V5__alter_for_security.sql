-- Drop the existing foreign key constraint
ALTER TABLE Response DROP FOREIGN KEY fk_response_author;
ALTER TABLE Topic DROP FOREIGN KEY fk_topic_author;

-- Recreate the foreign key with ON DELETE CASCADE
ALTER TABLE Response
ADD CONSTRAINT fk_response_author
FOREIGN KEY (author_id) REFERENCES User(id)
ON DELETE CASCADE;

ALTER TABLE Topic
ADD CONSTRAINT fk_topic_author
FOREIGN KEY (author_id) REFERENCES User(id)
ON DELETE CASCADE;

-- Rename the column 'name' to 'username' in the 'User' table
ALTER TABLE User CHANGE COLUMN name username VARCHAR(255) NOT NULL;

-- Add `enabled` column with a default value of true
ALTER TABLE User ADD COLUMN enabled BOOL NOT NULL DEFAULT TRUE;

-- Delete all existing users
DELETE FROM User;

-- Insert new users with the specified password
INSERT INTO User (id, username, email, password, profile_id, enabled)
VALUES 
    (1, 'user1', 'user1@example.com', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', 1, TRUE),
    (2, 'user2', 'user2@example.com', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', 2, TRUE),
    (3, 'user3', 'user3@example.com', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', 3, TRUE);

-- Table: Topic
INSERT INTO Topic (id,title, message, creation_date, status, author_id, course_id) VALUES
(1,'What is Java?', 'Can someone explain the basics of Java programming?', NOW(), 'OPEN', 2, 1),
(2,'What is Calculus?', 'How do I solve calculus integrals?', NOW(), 'OPEN', 2, 2),
(3,'When did WWII start?', 'Looking for insights about WWII timeline.', NOW(), 'CLOSED', 3, 3);

-- Table: Response
INSERT INTO Response (message, topic_id, creationDate, author_id, isSolution) VALUES
('Java is an object-oriented programming language.', 1, NOW(), 1, TRUE),
('You can solve integrals using substitution.', 2, NOW(), 2, TRUE),
('WWII started in 1939.', 3, NOW(), 3, TRUE);