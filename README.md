# ForoHub Project

ForoHub is a web-based forum application that allows users to create, view, and manage topics and responses. It also includes user authentication, role-based access, and topic categorization.

## Features
- **User Authentication**: Secure login and registration system using JWT for token-based authentication.
- **Role Management**: Assign roles (e.g., ADMIN, USER) to control access levels.
- **Topic Management**: Create, update, and delete topics with associated courses and authors.
- **Response Management**: Add responses to topics, mark responses as solutions, and cascade deletion of topics and responses.
- **Pagination and Sorting**: View topics and responses with pageable results.
- **Flyway Migrations**: Database schema versioning and seed data.
- **Swagger Integration**: API documentation with SpringDoc OpenAPI.

---

## Technologies Used
- **Spring Boot**: Backend framework for building Java applications.
- **Spring Security**: Provides authentication and authorization.
- **Flyway**: Manages database migrations.
- **JPA (Hibernate)**: ORM for interacting with the database.
- **MySQL**: Relational database for data storage.
- **JWT**: JSON Web Tokens for secure authentication.
- **Lombok**: Reduces boilerplate code with annotations.
- **SpringDoc OpenAPI**: Generates API documentation.

---

## Prerequisites
- Java 17 or later
- Maven 3.8 or later
- MySQL 8.0 or later

---

## Setup Instructions

### Clone the Repository
```bash
git clone https://github.com/username/forohub.git
cd forohub
```

### Configure the Database
1. Create a MySQL database named `survey`.
2. Update the `application.properties` file with your database credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/survey
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```


### Access the Application
- Application URL: [http://localhost:8080](http://localhost:8080)
- Swagger Documentation: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## API Endpoints
### Authentication
- **POST** `/auth/register` - Register a new user
- **POST** `/auth/login` - Log in and obtain a JWT token

### Topics
- **GET** `/topics` - List all topics
- **POST** `/topics` - Create a new topic
- **PUT** `/topics/{id}` - Update a topic
- **DELETE** `/topics/{id}` - Delete a topic

### Responses
- **POST** `/responses` - Add a response to a topic

---

## Database Schema
### Tables
- **User**
- **Profile**
- **Topic**
- **Response**
- **Course**



