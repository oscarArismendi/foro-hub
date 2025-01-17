-- V2: Insert seed data for all tables

-- Table: Profile
INSERT INTO Profile (name) VALUES 
('Administrator'),
('Teacher'),
('Student');

-- Table: Course
INSERT INTO Course (name, category) VALUES 
('Introduction to Programming', 'Technology'),
('Advanced Mathematics', 'Science'),
('Modern History', 'Humanities');

-- Table: User
INSERT INTO User (name, email, password, profile_id) VALUES
('Alice Johnson', 'alice@example.com', 'password123', 1), -- Administrator
('Bob Smith', 'bob@example.com', 'password123', 2),       -- Teacher
('Charlie Brown', 'charlie@example.com', 'password123', 3); -- Student

-- Table: Topic
INSERT INTO Topic (title, message, creation_date, status, author_id, course_id) VALUES
('What is Java?', 'Can someone explain the basics of Java programming?', NOW(), 'OPEN', 2, 1),
('What is Calculus?', 'How do I solve calculus integrals?', NOW(), 'OPEN', 2, 2),
('When did WWII start?', 'Looking for insights about WWII timeline.', NOW(), 'CLOSED', 3, 3);

-- Table: Response
INSERT INTO Response (message, topic_id, creationDate, author_id, isSolution) VALUES
('Java is an object-oriented programming language.', 1, NOW(), 1, TRUE),
('You can solve integrals using substitution.', 2, NOW(), 2, TRUE),
('WWII started in 1939.', 3, NOW(), 3, TRUE);
