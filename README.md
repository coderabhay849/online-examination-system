# Online Examination System

Backend application for an online examination platform developed using Spring Boot, PostgreSQL and Spring Security.

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT
- PostgreSQL
- Maven
- Docker
- Swagger / OpenAPI
- JUnit and Mockito

## Main Features

### Admin

- Create users
- Create, update and delete courses
- View all courses
- Search, pagination and sorting for courses
- View basic system reports

### Instructor

- Create and update exams
- Publish exams
- Create questions
- Add options for MCQ questions
- Get questions by exam
- Generate random questions

### Student

- Register and login
- View available published exams
- Start an exam attempt
- Submit answers
- Negative marking
- Multiple attempts
- View result
- Download result
- View exam history
- View leaderboard

## Security

- JWT based authentication
- Role based access control
- Password encryption using BCrypt
- Separate access for Admin, Instructor and Student
- Only one active JWT token is allowed for a user
- Audit log for login activity

## Database

The application uses PostgreSQL.

Main tables:

- users
- roles
- courses
- exams
- questions
- options
- student_attempts
- attempt_answers
- results
- audit_logs

## API Documentation

Swagger UI is available at:

http://localhost:9096/swagger-ui/index.html

## Postman Collection

The Postman collection is available inside the `postman` folder.

```text
postman/
└── Online-Examination-System.postman_collection.json