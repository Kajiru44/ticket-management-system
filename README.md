🎫 Ticket Management System

A RESTful backend application for managing support tickets, built with
Java and Spring Boot.

The project provides a structured REST API for creating, retrieving,
updating and deleting tickets. It uses Spring Data JPA,
Hibernate and PostgreSQL for persistent data storage.

The project is developed as a Java backend portfolio project, with a
focus on clean architecture, REST API design, database integration,
validation, exception handling and automated testing.

📌 Project Status

🚀 Core API and API quality features implemented

✅ Implemented

Spring Boot application

REST API

Layered architecture

Ticket entity

Ticket repository

Ticket service

Ticket controller

Create tickets

Retrieve all tickets

Retrieve ticket by ID

Update tickets

Delete tickets

PostgreSQL integration

Ticket status

Ticket priority

Automatic creation timestamp

DTO layer

Request validation with @Valid and @NotBlank

Global exception handling

Custom TicketNotFoundException

HTTP 404 handling

Clean validation error responses

JUnit unit tests

Mockito mocking

3 service unit tests

API testing with Postman

Git / GitHub integration

🔜 Planned

Authentication

Authorization

User management

Ticket assignment

Ticket comments

Ticket history

Search and filtering

Pagination

Swagger / OpenAPI documentation

Controller tests

Integration tests

Docker

CI/CD

Frontend

🏗️ Architecture

The application follows a layered backend architecture.

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

Controller Layer

The controller handles incoming HTTP requests and maps them to the
appropriate service methods.

It exposes the REST API endpoints and handles request/response DTOs.

Service Layer

The service layer contains the application's business logic.

It is responsible for operations such as:

Creating tickets

Retrieving tickets

Updating tickets

Deleting tickets

Handling missing tickets

Repository Layer

The repository layer handles communication with the database through
Spring Data JPA.

The application uses TicketRepository to access ticket data.

DTO Layer

The DTO layer separates API data transfer from the internal database
entity.

Currently the project contains:

TicketRequest

TicketResponse

TicketRequest is used for incoming API data, while TicketResponse is
used for outgoing API data.

Model Layer

The model layer contains the application's domain objects.

Currently the project contains:

Ticket

TicketStatus

TicketPriority

Exception Layer

The application contains centralized exception handling.

Currently implemented:

TicketNotFoundException

GlobalExceptionHandler

Validation error handling

This allows the API to return appropriate HTTP responses for missing
resources and invalid requests.

🛠️ Technology Stack

Technology        Purpose

Java              Backend programming language
Spring Boot       Backend framework
Spring Web        REST API development
Spring Data JPA   Database access
Hibernate         Object-relational mapping
PostgreSQL        Relational database
Maven             Dependency and build management
JUnit             Automated testing
Mockito           Unit test mocking
Postman           API testing
IntelliJ IDEA     Development environment
Git               Version control
GitHub            Source code hosting

📁 Project Structure

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
│   │   │               ├── dto/
│   │   │               │   ├── TicketRequest.java
│   │   │               │   └── TicketResponse.java
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
│           └── com/
│               └── kajiru/
│                   └── ticketmanagementsystem/
│                       └── service/
│                           └── TicketServiceTest.java
│
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md

🎫 Ticket Model

A ticket currently contains the following information:

Field           Type               Description

id            Long             Unique ticket identifier
title         String           Short description of the issue
description   String           Detailed description
status        TicketStatus     Current ticket state
priority      TicketPriority   Ticket priority
createdAt     LocalDateTime    Time the ticket was created

The creation timestamp is automatically generated when a ticket is
persisted.

📊 Ticket Status

Ticket status is represented by the TicketStatus enum.

Currently available statuses:

OPEN
IN_PROGRESS
CLOSED

Example:

{
  "status": "IN_PROGRESS"
}

🚨 Ticket Priority

Ticket priority is represented by the TicketPriority enum.

Currently available priorities:

LOW
MEDIUM
HIGH

Example:

{
  "priority": "HIGH"
}

🌐 REST API

The API uses the following base URL:

http://localhost:8080/api/tickets

Available Endpoints

Method     Endpoint              Description

POST     /api/tickets        Create a new ticket
GET      /api/tickets        Retrieve all tickets
GET      /api/tickets/{id}   Retrieve a specific ticket
PUT      /api/tickets/{id}   Update a ticket
DELETE   /api/tickets/{id}   Delete a ticket

➕ Create a Ticket

POST /api/tickets

Creates a new ticket.

Request

{
  "title": "Login funktioniert nicht",
  "description": "Der Benutzer kann sich nicht anmelden.",
  "status": "OPEN",
  "priority": "HIGH"
}

Response

{
  "id": 1,
  "title": "Login funktioniert nicht",
  "description": "Der Benutzer kann sich nicht anmelden.",
  "status": "OPEN",
  "priority": "HIGH",
  "createdAt": "2026-09-25T12:00:00"
}

📋 Get All Tickets

GET /api/tickets

Returns all tickets stored in the database.

Example Response

[
  {
    "id": 1,
    "title": "Login funktioniert nicht",
    "description": "Der Benutzer kann sich nicht anmelden.",
    "status": "OPEN",
    "priority": "HIGH",
    "createdAt": "2026-09-25T12:00:00"
  }
]

🔎 Get Ticket by ID

GET /api/tickets/{id}

Returns a specific ticket based on its ID.

Example

GET /api/tickets/1

Response

{
  "id": 1,
  "title": "Login funktioniert nicht",
  "description": "Der Benutzer kann sich nicht anmelden.",
  "status": "OPEN",
  "priority": "HIGH",
  "createdAt": "2026-09-25T12:00:00"
}

✏️ Update a Ticket

PUT /api/tickets/{id}

Updates an existing ticket.

Example

PUT /api/tickets/1

Request

{
  "title": "Login funktioniert jetzt",
  "description": "Der Login wurde repariert.",
  "status": "IN_PROGRESS",
  "priority": "HIGH"
}

Response

{
  "id": 1,
  "title": "Login funktioniert jetzt",
  "description": "Der Login wurde repariert.",
  "status": "IN_PROGRESS",
  "priority": "HIGH",
  "createdAt": "2026-09-25T12:00:00"
}

🗑️ Delete a Ticket

DELETE /api/tickets/{id}

Deletes an existing ticket.

Example

DELETE /api/tickets/1

Response

200 OK

❌ Validation

Incoming ticket requests are validated using Jakarta Bean Validation.

For example, title and description cannot be blank.

Invalid request:

{
  "title": "",
  "description": "",
  "status": "OPEN",
  "priority": "HIGH"
}

The API returns:

400 Bad Request

with a clean JSON response:

{
  "title": "must not be blank",
  "description": "must not be blank"
}

Validation is implemented using:

@Valid

@NotBlank

GlobalExceptionHandler

❌ Error Handling

The application uses a custom exception for tickets that cannot be
found.

For example:

GET /api/tickets/999

If ticket 999 does not exist, the API returns:

404 Not Found

with:

Ticket with id 999 not found

The request is handled through:

TicketNotFoundException
        │
        ▼
GlobalExceptionHandler
        │
        ▼
HTTP 404 Not Found

This keeps exception handling separate from the controller and provides
consistent responses for missing resources.

🗄️ Database

The application uses PostgreSQL for persistent data storage.

Spring Data JPA and Hibernate are used to map Java objects to database
entities.

Database configuration is located in:

src/main/resources/application.properties

Example configuration:

spring.datasource.url=jdbc:postgresql://localhost:5432/ticketdb
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

⚠️ Never commit real passwords, API keys or other secrets to a public
GitHub repository.

For production environments, sensitive configuration should be provided
through environment variables or another secure configuration mechanism.

🧪 Automated Testing

The project contains unit tests for the service layer using JUnit 5
and Mockito.

Current tests include:

createTicket_shouldSaveTicket

getTicketById_shouldReturnTicket

getTicketById_shouldThrowExceptionWhenNotFound

Current result:

3 tests passed
3 tests total

The tests use Mockito to mock TicketRepository, allowing the service
layer to be tested independently from the database.

Run all tests with:

.\mvnw.cmd test

🧪 API Testing

The REST API has been tested using Postman.

Tested functionality includes:

Successful POST requests

Successful GET requests

Successful PUT requests

Successful DELETE requests

Retrieval of individual tickets

400 Bad Request validation handling

404 Not Found handling for non-existing tickets

🔄 Request Flow

A typical request flows through the application as follows:

HTTP Request
     │
     ▼
TicketController
     │
     ▼
TicketRequest
     │
     ▼
Validation
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

The response travels back through the application and is converted into
a TicketResponse.

🧩 Why Layered Architecture?

The project uses a layered architecture to separate responsibilities.

Controller
    ↓
Service
    ↓
Repository
    ↓
Database

This separation provides:

Clear responsibilities

Easier maintenance

Easier testing

Better scalability

Reduced coupling

Cleaner business logic

Easier future development

🔐 Security

The project currently contains a Spring Security configuration.

At the current development stage, the API is configured to allow
requests while the core ticket management functionality is being
developed.

Authentication and authorization are planned for a later development
stage.

Planned security features include:

User registration

Login

Password hashing

JWT authentication

Role-based authorization

Protected endpoints

Potential roles:

USER
SUPPORT
ADMIN

🛣️ Roadmap

Phase 1 --- Core API

Project setup

Spring Boot application

Ticket entity

Ticket repository

Ticket service

Ticket controller

Create ticket

Get all tickets

Get ticket by ID

Update ticket

Delete ticket

PostgreSQL integration

Ticket status

Ticket priority

Exception handling

404 handling

Phase 2 --- API Quality

DTOs

Request validation

Improved error responses

HTTP 400 validation handling

Phase 3 --- Testing

Service unit tests

Mockito

Controller tests

Integration tests

Testcontainers

Automated API tests

Phase 4 --- Authentication

User entity

User registration

Login

Password hashing

JWT authentication

Role-based authorization

Protected endpoints

Phase 5 --- Advanced Ticket Management

Ticket assignment

User relationships

Ticket comments

Ticket history

Categories

Search

Filtering

Sorting

Pagination

Phase 6 --- Documentation & Deployment

Swagger / OpenAPI

Docker

Docker Compose

Production configuration

Environment variables

CI/CD

Cloud deployment

Monitoring

Phase 7 --- Frontend

Web frontend

Login interface

Ticket dashboard

Ticket creation

Ticket editing

Ticket filtering

User management

Admin dashboard

🎯 Project Goals

The main goal of this project is to build a practical backend
application while demonstrating real-world Java and Spring Boot
development.

The project focuses on:

Java

Spring Boot

REST API design

CRUD operations

HTTP methods

HTTP status codes

Dependency Injection

Layered architecture

DTOs

Request validation

Spring Data JPA

Hibernate

PostgreSQL

Object-relational mapping

Exception handling

Global exception handling

JUnit

Mockito

Maven

API testing

Git

GitHub

Backend architecture

💻 Development Environment

The project is currently developed using:

IntelliJ IDEA

Java

Spring Boot

Maven

PostgreSQL

Postman

Git

GitHub

📦 Build

The project uses Maven for dependency management and building.

Build the project:

./mvnw clean package

On Windows:

.\mvnw.cmd clean package

Run tests:

./mvnw test

On Windows:

.\mvnw.cmd test

Run the application:

./mvnw spring-boot:run

On Windows:

.\mvnw.cmd spring-boot:run

🚀 Getting Started

Prerequisites

Make sure the following software is installed:

Java

PostgreSQL

Git

IntelliJ IDEA or another Java IDE

Postman or another REST client

1. Clone the Repository

git clone https://github.com/Kajiru44/ticket-management-system.git

Navigate into the project:

cd ticket-management-system

2. Create the PostgreSQL Database

Create a database named:

ticketdb

For example:

CREATE DATABASE ticketdb;

3. Configure PostgreSQL

Open:

src/main/resources/application.properties

Configure your local PostgreSQL connection:

spring.datasource.url=jdbc:postgresql://localhost:5432/ticketdb
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

4. Start the Application

Using the Maven Wrapper on Windows:

.\mvnw.cmd spring-boot:run

Alternatively, start the application directly from IntelliJ IDEA by
running:

TicketManagementSystemApplication

The API will then be available at:

http://localhost:8080

📈 Current Development Direction

The current foundation is:

Java
  │
  ▼
Spring Boot
  │
  ├── Controller
  │
  ├── DTO
  │
  ├── Validation
  │
  ├── Service
  │
  ├── Repository
  │
  ├── Exception Handling
  │
  └── Model
       │
       ▼
   PostgreSQL

The project is developed incrementally, with additional functionality
added on top of the existing backend architecture.

📚 Learning Focus

This project is also intended as a practical learning environment.

Instead of building only isolated examples, the goal is to continuously
expand one real application and introduce additional backend concepts.

The development path currently includes:

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
Layered Architecture
       ↓
Exception Handling
       ↓
Validation
       ↓
DTOs
       ↓
Unit Testing
       ↓
Authentication
       ↓
Authorization
       ↓
Docker
       ↓
CI/CD
       ↓
Deployment

🔮 Future Vision

The long-term goal is to turn the current CRUD API into a more complete
ticket management platform.

A potential future architecture could look like:

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
                    ┌─────────────────┼─────────────────┐
                    │                 │                 │
                    ▼                 ▼                 ▼
             ┌─────────────┐   ┌─────────────┐   ┌─────────────┐
             │ Controller  │   │   Service   │   │  Security   │
             └─────────────┘   └──────┬──────┘   └─────────────┘
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

Additional infrastructure such as Docker, CI/CD and cloud deployment can
later be added around the application.

👨‍💻 Author

Kajiru44

GitHub:

https://github.com/Kajiru44

📄 License

This project is currently developed as a personal portfolio and learning
project.

⭐ This project demonstrates a practical Java / Spring Boot REST
backend with PostgreSQL, DTOs, validation, exception handling and
automated unit testing.
