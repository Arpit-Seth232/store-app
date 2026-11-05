# Store App

A simple Spring Boot backend application for managing a store system. It provides REST APIs for products, categories, customers, orders, and integrates with external services.

---

## Main Features

- **CRUD operations** for:
    - Products
    - Categories
    - Customers
    - Orders & Order Items
- **External API integration** for dummy products using WebClient (Reactive).
- **Redis caching** for frequently accessed data.
- **AOP-based time measurement** for service method execution.
- **Database migrations** using Flyway.

---

## Tech Stack

### Core
- Java 17
- Spring Boot 3.x
- Maven For Dependency Management

### Persistence
- Spring Data JPA
- MySQL
- Flyway (DB migrations)
- HikariCP (connection pooling)

### Caching
- Spring Cache Abstraction
- Redis Cache

### Web
- Spring Web (REST)
- Spring WebFlux (Reactive APIs)
- WebClient (external API calls)

### Mapping & Validation
- MapStruct (DTO ↔ Entity mapping)
- Jakarta Validation (Bean Validation)

### Cross-Cutting Concerns
- Spring AOP (method execution time logging)

---

## Architecture Overview

- **Controller layer**  
  Exposes REST endpoints and handles request validation.

- **Service layer**  
  Contains business logic, caching annotations, and transactional operations.

- **Repository layer**  
  Uses Spring Data JPA with optimized queries.

- **Mapper layer**  
  Converts between entities and DTOs using MapStruct.

- **Config layer**  
  Centralized configuration for Redis, WebClient, JPA auditing, and connection pooling.

---

## OpenAPI & Swagger

This project uses **Springdoc OpenAPI** to generate API documentation automatically.

- **Swagger UI**
  ```text
  http://localhost:8080/swagger
  ```

- **OpenAPI JSON**
  ```text
  http://localhost:8080/api-docs
  ```

---

## Getting Started

### Prerequisites
- Java 17+
- Docker & Docker Compose

### 1. Setup Environment
Copy the example environment file and update any configurations (e.g. database credentials or ports) if needed:
```bash
cp .env.example .env
```

### 2. Start Infrastructure (MySQL & Redis)
Spin up the database and cache containers:
```bash
docker compose up -d
```

### 3. Run the Application
```bash
./mvnw spring-boot:run
```
Once running, access the Swagger UI at `http://localhost:8080/swagger`.

### 4. Run Tests
```bash
./mvnw clean verify
```

### 5. Stop Infrastructure
To stop the background containers:
```bash
docker compose down
```

---

## Code Style & Formatting

Code formatting is enforced using `formatter-maven-plugin`. Run these commands before committing:

- **Auto-format codebase**:
  ```bash
  ./mvnw formatter:format
  ```

- **Validate formatting**:
  ```bash
  ./mvnw formatter:validate
  ```

---

## Continuous Integration (CI)

Every push and pull request to `main` triggers our GitHub Actions pipeline, which runs 4 independent jobs:
- **`formatting`**: Checks Java code formatting with `formatter-maven-plugin`.
- **`build`**: Compiles production and test sources.
- **`test`**: Executes all unit and integration tests against containerized MySQL and Redis services.
- **`run`**: Smoke tests application startup and checks health via the Swagger documentation endpoint.

---

## Contributing

Contributions are always welcome! Before opening an issue or pull request, please read our [Contributing Guide](CONTRIBUTING.md) for any details needed.

---

## Configuration

- Environment variables are loaded from `.env`.
- Centralized application configuration via `application.yml`.
