# Expense Tracker API (Backend)

Backend application for tracking personal expenses, built with **Java 25**, **Spring Boot**, and **PostgreSQL**.  
Users can register or log in, add, edit, delete expenses, and fetch/export all records via REST API.  

---

## Tech Stack

- Java 25  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Maven  
- Jackson  

---

## Architecture

- `api` — REST controllers  
- `service` — business logic  
- `repository` — database access layer  
- `entity` — JPA entities  
- `dto` — request and response models  

---

## How to Run

1. **Clone the repository**

```bash
git clone https://github.com/your-username/ExpenseTracker_API_JAVA.git
cd ExpenseTracker_API_JAVA
```
Create PostgreSQL database
```
CREATE DATABASE expense_tracker;
```
Backend configuration (all in one place)
```
server:
  port: 8080

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/expense_tracker
    username: postgres
    password: password
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true

  jackson:
    serialization:
      indent-output: true
```
Run Backend
```
mvn spring-boot:run
```
Backend will be available at http://localhost:8080.
## API Examples

### Register user
```
POST /auth/register
Content-Type: application/json

{
  "email": "test@mail.com",
  "password": "123456"
}
```
### Login user
```
POST /auth/login
Content-Type: application/json

{
  "email": "test@mail.com",
  "password": "123456"
}
```
## CRUD Expenses
- Create expense: POST /expenses

- Get all expenses: GET /expenses

- Update expense: PUT /expenses/{id}

- Delete expense: DELETE /expenses/{id}

Authorization via JWT in Authorization: Bearer <token> header.

## Team
- Dima Polegenkii — Backend Developer (Spring Boot + Java)
- telegram: @squizzysw
