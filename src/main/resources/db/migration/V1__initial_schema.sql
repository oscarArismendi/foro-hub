-- Table: Profile
CREATE TABLE Profile (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Table: Course
CREATE TABLE Course (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(100) NOT NULL
);

-- Table: User
CREATE TABLE User (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    profile_id BIGINT NOT NULL,
    CONSTRAINT fk_user_profile FOREIGN KEY (profile_id) REFERENCES Profile(id)
);

-- Table: Topic
CREATE TABLE Topic (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(255) NOT NULL,
    author_id BIGINT NOT NULL, -- Consistent with JPA entity
    course_id BIGINT NOT NULL, -- Consistent with JPA entity
    CONSTRAINT fk_topic_author FOREIGN KEY (author_id) REFERENCES User(id),
    CONSTRAINT fk_topic_course FOREIGN KEY (course_id) REFERENCES Course(id)
);

-- Table: Response
CREATE TABLE Response (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    message TEXT NOT NULL,
    topic_id BIGINT NOT NULL, -- Consistent with JPA entity
    creationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    author_id BIGINT NOT NULL, -- Consistent with JPA entity
    isSolution BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_response_topic FOREIGN KEY (topic_id) REFERENCES Topic(id),
    CONSTRAINT fk_response_author FOREIGN KEY (author_id) REFERENCES User(id)
);
