# Sales Management API

A RESTful backend service for sales management, built with **Java 11**, **Spring Boot 2.7**, and **MySQL**. Features JWT-based authentication via Spring Security and a clean layered architecture using JPA/Hibernate and Lombok.

## Tech Stack

|Layer      |Technology                 |
|-----------|---------------------------|
|Language   |Java 11                    |
|Framework  |Spring Boot 2.7.8          |
|Security   |Spring Security 5.7        |
|Persistence|Spring Data JPA / Hibernate|
|Database   |MySQL                      |
|Utilities  |Lombok                     |
|Build Tool |Maven                      |

## Features

- **Authentication & Authorization** — secured endpoints using Spring Security
- **Database integration** — full persistence with JPA entities and MySQL
- **Layered architecture** — clean separation of Controller → Service → Repository
- **Lombok** — reduced boilerplate with annotations like `@Data`, `@Builder`, `@AllArgsConstructor`
- **Spring DevTools** — hot reload enabled for local development

## Project Structure

```
src/
└── main/
    └── java/
        └── com/app/api/MyProject/
            ├── controller/    # REST endpoints
            ├── service/       # Business logic
            ├── repository/    # Data access layer (JPA)
            ├── model/         # JPA entities
            └── security/      # Spring Security configuration
```

## Getting Started

### Prerequisites

- Java 11+
- MySQL 8+
- Maven 3.6+

### Setup

1. Clone the repo:

   ```bash
   git clone https://github.com/Dybuc23/MyProject.git
   cd MyProject
   ```
1. Create the database:

   ```sql
   CREATE DATABASE salesdb;
   ```
1. Configure `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/salesdb
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```
1. Run the application:

   ```bash
   ./mvnw spring-boot:run
   ```

The API will be available at `http://localhost:8080`.

## API Endpoints

|Method|Endpoint         |Description      |Auth Required|
|------|-----------------|-----------------|-------------|
|POST  |`/auth/login`    |Authenticate user|No           |
|GET   |`/api/sales`     |Get all sales    |Yes          |
|POST  |`/api/sales`     |Create a new sale|Yes          |
|PUT   |`/api/sales/{id}`|Update a sale    |Yes          |
|DELETE|`/api/sales/{id}`|Delete a sale    |Yes          |


> Exact endpoints may vary — see controller classes for full route mapping.

## What I Learned

- Implementing stateless authentication with Spring Security
- Structuring a Spring Boot project with clean separation of concerns
- Managing database relationships with JPA/Hibernate
- Using Lombok to write cleaner, more maintainable Java code
