# Store App

[![CI Pipeline](https://github.com/ahmedmmordi/store-app/actions/workflows/ci.yml/badge.svg)](https://github.com/ahmedmmordi/store-app/actions/workflows/ci.yml)

> **Personal Learning & Open-Source Practice**: This is a personal learning project, but it is open for anyone who wants to practice and simulate real-world open-source contributions (learning Git workflows, making pull requests, working with CI/CD pipelines, and collaborating on a Spring Boot backend).  
> ⭐ If you find this helpful, don't forget to **star the repo** and share it with your friends!

A Spring Boot 3.x store backend providing REST APIs for products, categories, customers, orders, and reactive external product integrations.

---

## Tech Stack & Architecture

- **Backend**: Java 17, Spring Boot 3.x (Web, WebFlux, Data JPA, Cache)
- **Database & Migration**: MySQL 8.0, Flyway migrations, HikariCP
- **Caching**: Redis Cache via Spring Cache abstraction
- **Mapping & Validation**: MapStruct, Jakarta Validation
- **Docs & Monitoring**: Springdoc OpenAPI (Swagger UI), Spring AOP execution logging

For a detailed breakdown of package responsibilities, request lifecycle, and data flow, see [ARCHITECTURE.md](ARCHITECTURE.md).

---

## Getting Started

### Prerequisites
- Java 17+
- Docker & Docker Compose

### 1. Setup Environment
```bash
cp .env.example .env
```

### 2. Start Infrastructure (MySQL & Redis)
```bash
docker compose up -d
```

### 3. Run the Application
```bash
./mvnw spring-boot:run
```
Access the interactive API docs at: [http://localhost:8080/swagger](http://localhost:8080/swagger)

### 4. Run Tests
```bash
./mvnw clean verify
```

### 5. Stop Infrastructure
```bash
docker compose down
```

---

## Code Style & Formatting

Code style is enforced via `formatter-maven-plugin`. Run these before committing:

```bash
./mvnw formatter:format    # Auto-format all files
./mvnw formatter:validate  # Validate formatting (runs in CI)
```

---

## Continuous Integration (CI)

Every push and pull request triggers our GitHub Actions pipeline, which runs 4 independent verification jobs:
1. **`formatting`**: Validates Java formatting with `formatter-maven-plugin`.
2. **`build`**: Verifies compilation of main and test sources.
3. **`test`**: Executes all tests against containerized MySQL & Redis.
4. **`run`**: Smoke tests boot and Swagger health response.

---

## Contributing

First-time open-source contributors are warmly welcomed! Please read our [Contributing Guide](CONTRIBUTING.md) for any details needed.
