# 🎫 Ticket Management System

A RESTful backend application for managing support tickets, built with **Java** and **Spring Boot**.

The project demonstrates a clean backend architecture with REST APIs, PostgreSQL, DTOs, validation, exception handling, JUnit and Mockito.

## 🚀 Features

- Create tickets
- Get all tickets
- Get a ticket by ID
- Update tickets
- Delete tickets
- PostgreSQL database integration
- Ticket status and priority
- DTOs (`TicketRequest` / `TicketResponse`)
- Request validation with `@Valid` and `@NotBlank`
- Global exception handling
- Custom `TicketNotFoundException`
- Clean JSON validation errors
- JUnit 5 unit tests
- Mockito
- API testing with Postman

## 🛠️ Tech Stack

- **Java**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL**
- **Maven**
- **JUnit 5**
- **Mockito**
- **Postman**
- **Git / GitHub**
- **IntelliJ IDEA**

## 🏗️ Architecture

```text
Client / Postman
       |
       v
TicketController
       |
       v
TicketService
       |
       v
TicketRepository
       |
       v
PostgreSQL
```

The application follows a layered architecture:

- **Controller** — handles HTTP requests and responses
- **DTO** — separates API data from the database entity
- **Service** — contains business logic
- **Repository** — handles database access
- **Model** — contains domain entities and enums
- **Exception** — centralized error handling

## 📁 Project Structure

```text
ticket-management-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/kajiru/ticketmanagementsystem/
│   │   │       ├── config/
│   │   │       │   └── SecurityConfig.java
│   │   │       ├── controller/
│   │   │       │   └── TicketController.java
│   │   │       ├── dto/
│   │   │       │   ├── TicketRequest.java
│   │   │       │   └── TicketResponse.java
│   │   │       ├── exception/
│   │   │       │   ├── GlobalExceptionHandler.java
│   │   │       │   └── TicketNotFoundException.java
│   │   │       ├── model/
│   │   │       │   ├── Ticket.java
│   │   │       │   ├── TicketPriority.java
│   │   │       │   └── TicketStatus.java
│   │   │       ├── repository/
│   │   │       │   └── TicketRepository.java
│   │   │       ├── service/
│   │   │       │   └── TicketService.java
│   │   │       └── TicketManagementSystemApplication.java
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│           └── com/kajiru/ticketmanagementsystem/
│               └── service/
│                   └── TicketServiceTest.java
│
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## 🎫 Ticket Model

A ticket contains:

| Field | Type | Description |
|---|---|---|
| `id` | `Long` | Unique ticket identifier |
| `title` | `String` | Short description of the issue |
| `description` | `String` | Detailed description |
| `status` | `TicketStatus` | Current ticket state |
| `priority` | `TicketPriority` | Ticket priority |
| `createdAt` | `LocalDateTime` | Creation timestamp |

The `createdAt` timestamp is automatically generated when a ticket is persisted.

## 📊 Ticket Status

Available statuses:

```text
OPEN
IN_PROGRESS
CLOSED
```

## 🚨 Ticket Priority

Available priorities:

```text
LOW
MEDIUM
HIGH
```

## 🌐 REST API

Base URL:

```text
http://localhost:8080/api/tickets
```

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/tickets` | Create a ticket |
| `GET` | `/api/tickets` | Get all tickets |
| `GET` | `/api/tickets/{id}` | Get a ticket |
| `PUT` | `/api/tickets/{id}` | Update a ticket |
| `DELETE` | `/api/tickets/{id}` | Delete a ticket |

### Create Ticket

`POST /api/tickets`

```json
{
  "title": "Login funktioniert nicht",
  "description": "Der Benutzer kann sich nicht anmelden.",
  "status": "OPEN",
  "priority": "HIGH"
}
```

### Get All Tickets

`GET /api/tickets`

Returns all tickets stored in the database.

### Get Ticket

`GET /api/tickets/1`

Returns the ticket with ID `1`.

### Update Ticket

`PUT /api/tickets/1`

```json
{
  "title": "Login funktioniert wieder",
  "description": "Der Login wurde repariert.",
  "status": "IN_PROGRESS",
  "priority": "HIGH"
}
```

### Delete Ticket

`DELETE /api/tickets/1`

Deletes the ticket with ID `1`.

## ❌ Validation

Incoming requests are validated using Jakarta Bean Validation.

For example, `title` and `description` cannot be blank.

Invalid request:

```json
{
  "title": "",
  "description": "",
  "status": "OPEN",
  "priority": "HIGH"
}
```

Response:

```text
400 Bad Request
```

Example JSON:

```json
{
  "title": "must not be blank",
  "description": "must not be blank"
}
```

## ❌ Exception Handling

If a requested ticket does not exist:

```text
GET /api/tickets/999
```

The API returns:

```text
404 Not Found
```

Example:

```text
Ticket with id 999 not found
```

The error is handled centrally by `GlobalExceptionHandler`.

## 🧪 Unit Testing

The service layer is tested with **JUnit 5** and **Mockito**.

Current tests:

- `createTicket_shouldSaveTicket`
- `getTicketById_shouldReturnTicket`
- `getTicketById_shouldThrowExceptionWhenNotFound`

Current result:

```text
3 tests passed
3 tests total
```

Run the tests on Windows:

```powershell
.\mvnw.cmd test
```

## 🧪 API Testing

The REST API has been tested with **Postman**.

Tested:

- `POST`
- `GET`
- `GET /{id}`
- `PUT`
- `DELETE`
- Validation errors (`400`)
- Missing tickets (`404`)

## 🗄️ Database

The application uses **PostgreSQL**.

Database:

```text
ticketdb
```

Example local configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ticketdb
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> **Important:** Never commit real passwords, API keys or other secrets to a public GitHub repository. Use environment variables or another secure configuration method.

## ▶️ Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/Kajiru44/ticket-management-system.git
cd ticket-management-system
```

### 2. Create the database

Create a PostgreSQL database named:

```text
ticketdb
```

### 3. Configure the database

Edit:

```text
src/main/resources/application.properties
```

and add your local PostgreSQL credentials.

### 4. Start the application

Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Or run `TicketManagementSystemApplication` directly from IntelliJ IDEA.

The API will be available at:

```text
http://localhost:8080
```

## 🧭 Roadmap

### API

- [x] CRUD operations
- [x] DTOs
- [x] Validation
- [x] Global exception handling
- [x] PostgreSQL integration

### Testing

- [x] Service unit tests
- [x] Mockito
- [ ] Controller tests
- [ ] Integration tests
- [ ] Testcontainers

### Security

- [x] Spring Security configuration
- [ ] Authentication
- [ ] JWT
- [ ] User management
- [ ] Role-based authorization

### Advanced Features

- [ ] Ticket assignment
- [ ] Comments
- [ ] Ticket history
- [ ] Search
- [ ] Filtering
- [ ] Pagination
- [ ] Swagger / OpenAPI
- [ ] Docker
- [ ] CI/CD

## 🎯 Project Goal

The goal of this project is to demonstrate practical backend development with Java and Spring Boot.

The project focuses on:

- REST API development
- Clean architecture
- Database integration
- DTOs
- Validation
- Exception handling
- Unit testing
- Git / GitHub
- Maintainable Java code

## 👨‍💻 Author

**Kajiru44**

GitHub:

https://github.com/Kajiru44

---

⭐ Personal Java / Spring Boot portfolio project.
