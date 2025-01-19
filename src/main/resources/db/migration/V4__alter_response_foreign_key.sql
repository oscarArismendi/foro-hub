-- Drop the existing foreign key constraint
ALTER TABLE Response DROP FOREIGN KEY fk_response_topic;

-- Recreate the foreign key with ON DELETE CASCADE
ALTER TABLE Response
ADD CONSTRAINT fk_response_topic
FOREIGN KEY (topic_id) REFERENCES Topic(id)
ON DELETE CASCADE;