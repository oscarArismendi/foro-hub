-- Table: Profile
CREATE TABLE Profile (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Table: Course
CREATE TABLE Course (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(100) NOT NULL
);

-- Table: User
CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    profile INT NOT NULL,
    CONSTRAINT fk_user_profile FOREIGN KEY (profile) REFERENCES Profile(id)
);

-- Table: Topic
CREATE TABLE Topic (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    creationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    author INT NOT NULL,
    course INT NOT NULL,
    responses INT DEFAULT 0,
    CONSTRAINT fk_topic_author FOREIGN KEY (author) REFERENCES User(id),
    CONSTRAINT fk_topic_course FOREIGN KEY (course) REFERENCES Course(id)
);

-- Table: Response
CREATE TABLE Response (
    id INT AUTO_INCREMENT PRIMARY KEY,
    message TEXT NOT NULL,
    topic INT NOT NULL,
    creationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    author INT NOT NULL,
    isSolution BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_response_topic FOREIGN KEY (topic) REFERENCES Topic(id),
    CONSTRAINT fk_response_author FOREIGN KEY (author) REFERENCES User(id)
);
