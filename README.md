﻿# ForoHub Project

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
**Important note: only auth endpoints works without JWT**
### Authentication
- **POST** `/auth/register` - Register a new user
  ![image](https://github.com/user-attachments/assets/8d4a6a14-8b03-42b3-b2fd-d975f8a2ddc3)

- **POST** `/auth/login` - Log in and obtain a JWT token
![image](https://github.com/user-attachments/assets/e9c12731-3ce4-4567-ad64-f783b770b6b0)

### Topics

- **GET** `/topics/{id}` - Find topic by id
  ![image](https://github.com/user-attachments/assets/4f81453e-67d4-4d08-b450-30ead094fe38)

- **GET** `/topics` - List all topics
  ![image](https://github.com/user-attachments/assets/c8f237b6-4ed2-43bd-ad2b-081c2f253014)

- **POST** `/topics` - Create a new topic
  ![image](https://github.com/user-attachments/assets/8f10aa6c-e2bc-426f-a7d1-158e5d237ba1)

- **PUT** `/topics/{id}` - Update a topic
  ![image](https://github.com/user-attachments/assets/f15a3446-b9bf-4447-9a69-9be33e8d1473)

- **DELETE** `/topics/{id}` - Delete a topic
![image](https://github.com/user-attachments/assets/2b9b7c40-bc8f-4051-b6ba-436087eedc65)


---

## Database Schema
### Tables
- **User**
- **Profile**
- **Topic**
- **Response**
- **Course**



