# 🎫 Ticket Management System

A RESTful backend application for managing support tickets, built with **Java** and **Spring Boot**.

The project provides a structured REST API for creating, retrieving, updating and deleting tickets. It uses **Spring Data JPA**, **Hibernate** and **PostgreSQL** for persistent data storage.

The project is being developed as a **Java backend portfolio project**, with a focus on clean architecture, REST API design, database integration and practical Spring Boot development.

---

## 📌 Project Status

🚧 **Currently under development**

The core ticket management functionality is implemented and working.

### ✅ Implemented

- [x] Spring Boot application
- [x] REST API
- [x] Ticket entity
- [x] Ticket repository
- [x] Ticket service
- [x] Ticket controller
- [x] Create tickets
- [x] Retrieve all tickets
- [x] Retrieve ticket by ID
- [x] Update tickets
- [x] Delete tickets
- [x] PostgreSQL integration
- [x] Ticket status
- [x] Ticket priority
- [x] Automatic creation timestamp
- [x] Custom `TicketNotFoundException`
- [x] Global exception handling
- [x] HTTP 404 handling
- [x] API testing with Postman
- [x] Git / GitHub integration

### 🔜 Planned

- [ ] Request validation
- [ ] DTO layer
- [ ] Improved API error responses
- [ ] Authentication
- [ ] Authorization
- [ ] User management
- [ ] Ticket assignment
- [ ] Ticket comments
- [ ] Ticket history
- [ ] Search and filtering
- [ ] Pagination
- [ ] Swagger / OpenAPI documentation
- [ ] Extended automated tests
- [ ] Docker
- [ ] CI/CD
- [ ] Frontend

---

# 🏗️ Architecture

The application follows a layered backend architecture.

```text
                         ┌─────────────────────┐
                         │       Client        │
                         │  Postman / Frontend │
                         └──────────┬──────────┘
                                    │
                                    │ HTTP / JSON
                                    ▼
                         ┌─────────────────────┐
                         │     Controller      │
                         │  TicketController   │
                         └──────────┬──────────┘
                                    │
                                    ▼
                         ┌─────────────────────┐
                         │       Service       │
                         │    TicketService    │
                         └──────────┬──────────┘
                                    │
                                    ▼
                         ┌─────────────────────┐
                         │      Repository     │
                         │   TicketRepository  │
                         └──────────┬──────────┘
                                    │
                                    ▼
                         ┌─────────────────────┐
                         │     PostgreSQL      │
                         │       Database      │
                         └─────────────────────┘
```

### Controller Layer

The controller handles incoming HTTP requests and maps them to the appropriate service methods.

The controller is responsible for exposing the REST API endpoints.

### Service Layer

The service layer contains the application's business logic.

It is responsible for operations such as:

- Creating tickets
- Retrieving tickets
- Updating tickets
- Deleting tickets
- Handling missing tickets

### Repository Layer

The repository layer handles communication with the database through **Spring Data JPA**.

The application uses `TicketRepository` to access ticket data.

### Model Layer

The model layer contains the application's domain objects.

Currently the project contains:

- `Ticket`
- `TicketStatus`
- `TicketPriority`

### Exception Layer

The application contains centralized exception handling.

Currently implemented:

- `TicketNotFoundException`
- `GlobalExceptionHandler`

This allows the API to return an appropriate `404 Not Found` response when a requested ticket does not exist.

---

# 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| Java | Backend programming language |
| Spring Boot | Backend framework |
| Spring Web | REST API development |
| Spring Data JPA | Database access |
| Hibernate | Object-relational mapping |
| PostgreSQL | Relational database |
| Maven | Dependency and build management |
| JUnit | Automated testing |
| Postman | API testing |
| IntelliJ IDEA | Development environment |
| Git | Version control |
| GitHub | Source code hosting |

---

# 📁 Project Structure

```text
ticket-management-system/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   │
│   ├── main/
│   │   │
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── kajiru/
│   │   │           └── ticketmanagementsystem/
│   │   │               │
│   │   │               ├── config/
│   │   │               │   └── SecurityConfig.java
│   │   │               │
│   │   │               ├── controller/
│   │   │               │   └── TicketController.java
│   │   │               │
│   │   │               ├── exception/
│   │   │               │   ├── GlobalExceptionHandler.java
│   │   │               │   └── TicketNotFoundException.java
│   │   │               │
│   │   │               ├── model/
│   │   │               │   ├── Ticket.java
│   │   │               │   ├── TicketPriority.java
│   │   │               │   └── TicketStatus.java
│   │   │               │
│   │   │               ├── repository/
│   │   │               │   └── TicketRepository.java
│   │   │               │
│   │   │               ├── service/
│   │   │               │   └── TicketService.java
│   │   │               │
│   │   │               └── TicketManagementSystemApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

---

# 🎫 Ticket Model

A ticket currently contains the following information:

| Field | Type | Description |
|---|---|---|
| `id` | `Long` | Unique ticket identifier |
| `title` | `String` | Short description of the issue |
| `description` | `String` | Detailed description |
| `status` | `TicketStatus` | Current ticket state |
| `priority` | `TicketPriority` | Ticket priority |
| `createdAt` | `LocalDateTime` | Time the ticket was created |

The creation timestamp is automatically generated when a ticket is persisted.

---

# 📊 Ticket Status

Ticket status is represented by the `TicketStatus` enum.

Currently available statuses:

```text
OPEN
IN_PROGRESS
CLOSED
```

Example:

```json
{
    "status": "IN_PROGRESS"
}
```

---

# 🚨 Ticket Priority

Ticket priority is represented by the `TicketPriority` enum.

Currently available priorities:

```text
LOW
MEDIUM
HIGH
```

Example:

```json
{
    "priority": "HIGH"
}
```

---

# 🌐 REST API

The API uses the following base URL:

```text
http://localhost:8080/api/tickets
```

## Available Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/tickets` | Create a new ticket |
| `GET` | `/api/tickets` | Retrieve all tickets |
| `GET` | `/api/tickets/{id}` | Retrieve a specific ticket |
| `PUT` | `/api/tickets/{id}` | Update a ticket |
| `DELETE` | `/api/tickets/{id}` | Delete a ticket |

---

# ➕ Create a Ticket

### `POST /api/tickets`

Creates a new ticket.

### Request

```json
{
    "title": "Login funktioniert nicht",
    "description": "Der Benutzer kann sich nicht anmelden.",
    "status": "OPEN",
    "priority": "HIGH"
}
```

### Response

```json
{
    "createdAt": "2026-09-21T21:16:41.4863717",
    "description": "Der Benutzer kann sich nicht anmelden.",
    "id": 2,
    "priority": "HIGH",
    "status": "OPEN",
    "title": "Login funktioniert nicht"
}
```

---

# 📋 Get All Tickets

### `GET /api/tickets`

Returns all tickets stored in the database.

### Example Response

```json
[
    {
        "createdAt": "2026-09-21T21:16:41.4863717",
        "description": "Der Benutzer kann sich nicht anmelden.",
        "id": 2,
        "priority": "HIGH",
        "status": "OPEN",
        "title": "Login funktioniert nicht"
    }
]
```

---

# 🔎 Get Ticket by ID

### `GET /api/tickets/{id}`

Returns a specific ticket based on its ID.

### Example

```text
GET /api/tickets/2
```

### Response

```json
{
    "createdAt": "2026-09-21T21:16:41.4863717",
    "description": "Der Benutzer kann sich nicht anmelden.",
    "id": 2,
    "priority": "HIGH",
    "status": "OPEN",
    "title": "Login funktioniert nicht"
}
```

---

# ✏️ Update a Ticket

### `PUT /api/tickets/{id}`

Updates an existing ticket.

### Example

```text
PUT /api/tickets/2
```

### Request

```json
{
    "title": "Login funktioniert jetzt",
    "description": "Der Login wurde repariert.",
    "status": "IN_PROGRESS",
    "priority": "HIGH"
}
```

### Response

```json
{
    "createdAt": "2026-09-21T21:16:41.4863717",
    "description": "Der Login wurde repariert.",
    "id": 2,
    "priority": "HIGH",
    "status": "IN_PROGRESS",
    "title": "Login funktioniert jetzt"
}
```

---

# 🗑️ Delete a Ticket

### `DELETE /api/tickets/{id}`

Deletes an existing ticket.

### Example

```text
DELETE /api/tickets/2
```

### Response

```text
200 OK
```

---

# ❌ Error Handling

The application uses a custom exception for tickets that cannot be found.

For example:

```text
GET /api/tickets/999
```

If ticket `999` does not exist, the API returns:

```text
404 Not Found
```

with the following response:

```text
Ticket with id 999 not found
```

The request is handled through:

```text
TicketNotFoundException
        │
        ▼
GlobalExceptionHandler
        │
        ▼
HTTP 404 Not Found
```

This keeps exception handling separate from the controller and provides a consistent response for missing resources.

---

# 🗄️ Database

The application uses **PostgreSQL** for persistent data storage.

Spring Data JPA and Hibernate are used to map Java objects to database entities.

Database configuration is located in:

```text
src/main/resources/application.properties
```

Example configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ticketdb
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> ⚠️ Never commit real passwords, API keys or other secrets to a public GitHub repository.

For production environments, sensitive configuration should be provided through environment variables or another secure configuration mechanism.

---

# 🚀 Getting Started

## Prerequisites

Make sure the following software is installed:

- Java
- PostgreSQL
- Git
- IntelliJ IDEA or another Java IDE
- Postman or another REST client

---

## 1. Clone the Repository

```bash
git clone https://github.com/Kajiru44/ticket-management-system.git
```

Navigate into the project:

```bash
cd ticket-management-system
```

---

## 2. Create the PostgreSQL Database

Create a database named:

```text
ticketdb
```

For example:

```sql
CREATE DATABASE ticketdb;
```

---

## 3. Configure PostgreSQL

Open:

```text
src/main/resources/application.properties
```

Configure your local PostgreSQL connection.

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ticketdb
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
```

---

## 4. Start the Application

Using the Maven Wrapper on Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Alternatively, start the application directly from IntelliJ IDEA by running:

```text
TicketManagementSystemApplication
```

The API will then be available at:

```text
http://localhost:8080
```

---

# 🧪 Testing the API

The REST API can be tested using Postman.

A typical workflow looks like this:

```text
POST /api/tickets
        │
        ▼
Create Ticket
        │
        ▼
GET /api/tickets
        │
        ▼
Get All Tickets
        │
        ▼
GET /api/tickets/{id}
        │
        ▼
Get Specific Ticket
        │
        ▼
PUT /api/tickets/{id}
        │
        ▼
Update Ticket
        │
        ▼
DELETE /api/tickets/{id}
        │
        ▼
Delete Ticket
```

The API has been tested with:

- Successful `POST` requests
- Successful `GET` requests
- Successful `PUT` requests
- Successful `DELETE` requests
- Retrieval of individual tickets
- `404 Not Found` handling for non-existing tickets

---

# 🔄 Request Flow

A typical request flows through the application as follows:

```text
HTTP Request
     │
     ▼
TicketController
     │
     ▼
TicketService
     │
     ▼
TicketRepository
     │
     ▼
Hibernate / JPA
     │
     ▼
PostgreSQL
```

The response then travels back through the same layers:

```text
PostgreSQL
     │
     ▼
Hibernate / JPA
     │
     ▼
TicketRepository
     │
     ▼
TicketService
     │
     ▼
TicketController
     │
     ▼
JSON Response
```

This separation makes the application easier to maintain and allows individual layers to evolve independently.

---

# 🧩 Why Layered Architecture?

The project uses a layered architecture to separate responsibilities.

For example, the controller should not directly contain database logic.

Instead:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

This separation provides several advantages:

- Clear responsibilities
- Easier maintenance
- Easier testing
- Better scalability
- Reduced coupling
- Cleaner business logic
- Easier future development

---

# 🔐 Security

The project currently contains a Spring Security configuration.

At the current development stage, the API is configured to allow requests while the core ticket management functionality is being developed.

Authentication and authorization are planned for a later development stage.

The planned security architecture includes:

```text
Client
   │
   ▼
Authentication
   │
   ▼
Authorization
   │
   ▼
Protected REST API
```

Future security features may include:

- User registration
- Login
- Password hashing
- JWT authentication
- Role-based authorization
- Protected endpoints

Potential roles:

```text
USER
SUPPORT
ADMIN
```

---

# 🧪 Testing Strategy

Testing will be expanded as the project grows.

Planned test layers include:

```text
Unit Tests
     │
     ▼
Service Tests
     │
     ▼
Controller Tests
     │
     ▼
Integration Tests
     │
     ▼
API Tests
```

Planned technologies include:

- JUnit
- Spring Boot Test
- Mockito
- Testcontainers

---

# 🛣️ Roadmap

The project will evolve from a basic CRUD REST API into a more complete ticket management platform.

## Phase 1 — Core API

- [x] Project setup
- [x] Spring Boot application
- [x] Ticket entity
- [x] Ticket repository
- [x] Ticket service
- [x] Ticket controller
- [x] Create ticket
- [x] Get all tickets
- [x] Get ticket by ID
- [x] Update ticket
- [x] Delete ticket
- [x] PostgreSQL integration
- [x] Ticket status
- [x] Ticket priority
- [x] Exception handling
- [x] 404 handling

## Phase 2 — API Quality

- [ ] DTOs
- [ ] Validation
- [ ] Improved error responses
- [ ] HTTP status improvements
- [ ] Swagger / OpenAPI
- [ ] API documentation

## Phase 3 — Authentication

- [ ] User entity
- [ ] User registration
- [ ] Login
- [ ] Password hashing
- [ ] JWT authentication
- [ ] Role-based authorization
- [ ] Protected endpoints

## Phase 4 — Advanced Ticket Management

- [ ] Ticket assignment
- [ ] User relationships
- [ ] Ticket comments
- [ ] Ticket history
- [ ] Categories
- [ ] Search
- [ ] Filtering
- [ ] Sorting
- [ ] Pagination

## Phase 5 — Testing

- [ ] Service unit tests
- [ ] Controller tests
- [ ] Repository tests
- [ ] Integration tests
- [ ] Testcontainers
- [ ] Automated API tests

## Phase 6 — Deployment

- [ ] Docker
- [ ] Docker Compose
- [ ] Production configuration
- [ ] Environment variables
- [ ] CI/CD
- [ ] Cloud deployment
- [ ] Monitoring

## Phase 7 — Frontend

- [ ] Web frontend
- [ ] Login interface
- [ ] Ticket dashboard
- [ ] Ticket creation
- [ ] Ticket editing
- [ ] Ticket filtering
- [ ] User management
- [ ] Admin dashboard

---

# 🎯 Project Goals

The main goal of this project is to build a practical backend application while demonstrating real-world Java and Spring Boot development.

The project focuses on understanding and applying:

- Java
- Spring Boot
- REST API design
- CRUD operations
- HTTP methods
- HTTP status codes
- Dependency Injection
- Layered architecture
- Spring Data JPA
- Hibernate
- PostgreSQL
- Object-relational mapping
- Exception handling
- Global exception handling
- Maven
- API testing
- Git
- GitHub
- Backend architecture

As the project grows, additional concepts such as authentication, authorization, DTOs, validation, testing, Docker and deployment will be introduced.

---

# 📈 Current Development Direction

The application is intentionally being developed incrementally.

The current foundation is:

```text
Java
  │
  ▼
Spring Boot
  │
  ├── Controller
  │
  ├── Service
  │
  ├── Repository
  │
  └── Model
        │
        ▼
     PostgreSQL
```

The next stages will build additional functionality on top of this foundation rather than replacing the existing architecture.

---

# 💻 Development Environment

The project is currently developed using:

- IntelliJ IDEA
- Java
- Spring Boot
- Maven
- PostgreSQL
- Postman
- Git
- GitHub

---

# 📦 Build

The project uses Maven for dependency management and building.

Build the project with:

```bash
./mvnw clean package
```

On Windows:

```powershell
.\mvnw.cmd clean package
```

Run tests with:

```bash
./mvnw test
```

On Windows:

```powershell
.\mvnw.cmd test
```

Run the application with:

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

---

# 🌱 Git Workflow

The project uses Git for version control.

The repository is hosted on GitHub:

**https://github.com/Kajiru44/ticket-management-system**

Development is performed incrementally through commits representing individual project milestones.

Example:

```bash
git add .
git commit -m "Implement ticket management API"
git push
```

---

# 📚 Learning Focus

This project is also intended as a practical learning environment.

Instead of building only isolated examples, the goal is to continuously expand one real application and introduce additional backend concepts as the project develops.

The development path is approximately:

```text
Java Fundamentals
       ↓
Spring Boot
       ↓
REST API
       ↓
JPA / Hibernate
       ↓
PostgreSQL
       ↓
Exception Handling
       ↓
Validation
       ↓
DTOs
       ↓
Authentication
       ↓
Authorization
       ↓
Testing
       ↓
Docker
       ↓
CI/CD
       ↓
Deployment
```

---

# 🚀 Future Vision

The long-term goal is to turn the current CRUD API into a more complete ticket management platform.

A potential final architecture could look like:

```text
                           ┌─────────────────────┐
                           │      Frontend       │
                           │    Web Application  │
                           └──────────┬──────────┘
                                      │
                                      │ REST / JSON
                                      ▼
                           ┌─────────────────────┐
                           │     Spring Boot     │
                           │       REST API      │
                           └──────────┬──────────┘
                                      │
                 ┌────────────────────┼────────────────────┐
                 │                    │                    │
                 ▼                    ▼                    ▼
          ┌─────────────┐      ┌─────────────┐      ┌─────────────┐
          │ Controller  │      │   Service   │      │  Security   │
          └─────────────┘      └──────┬──────┘      └─────────────┘
                                      │
                                      ▼
                              ┌─────────────┐
                              │ Repository  │
                              └──────┬──────┘
                                     │
                                     ▼
                              ┌─────────────┐
                              │ PostgreSQL  │
                              └─────────────┘
```

Additional infrastructure such as Docker, CI/CD and cloud deployment can later be added around the application.

---

# 👨‍💻 Author

**Kajiru44**

GitHub:

https://github.com/Kajiru44

---

# 📄 License

This project is currently developed as a personal portfolio and learning project.

---

⭐ **This project is actively being developed and expanded.**
