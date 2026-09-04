# 🚀 Spring Boot Learning Project

A hands-on **Spring Boot learning project** created to understand and practice commonly used backend technologies and development concepts.

This project focuses on learning how different Spring Boot components work together in a real-world backend application.

---

## 📌 Features

- 🌱 Spring Boot
- 🌐 REST API development
- 🧪 Unit Testing with JUnit 5
- 🎭 Mocking with Mockito
- 📝 Logging with SLF4J
- 📨 Asynchronous messaging with Apache Kafka
- ⚡ Caching with Redis
- 📧 Email communication using SMTP
- 🔗 External REST API integration
- 🗄️ Database integration
- ⚙️ Configuration management
- ❗ Exception handling
- 📦 Layered architecture
- 🔍 Request/Response validation

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java | Programming Language |
| Spring Boot | Backend Framework |
| Spring Web | REST API development |
| Spring Data JPA | Database interaction |
| JUnit 5 | Unit testing |
| Mockito | Mocking dependencies |
| SLF4J | Application logging |
| Apache Kafka | Asynchronous messaging |
| Redis | Caching |
| Spring Mail | SMTP email communication |
| REST Client | External API communication |
| Maven / Gradle | Dependency management |
| Git | Version control |

---

## 🏗️ Project Architecture

```text
                    ┌──────────────────────┐
                    │       Client         │
                    │  Postman / Frontend  │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │   REST Controller    │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │    Service Layer     │
                    │    Business Logic    │
                    └─────┬────┬────┬──────┘
                          │    │    │
             ┌────────────┘    │    └──────────────┐
             ▼                 ▼                   ▼
      ┌──────────────┐  ┌──────────────┐   ┌──────────────┐
      │  Repository  │  │    Redis     │   │ External API │
      │  / Database  │  │    Cache     │   │    Client    │
      └──────────────┘  └──────────────┘   └──────────────┘
                               │
                               ▼
                        ┌──────────────┐
                        │    Kafka     │
                        │ Message Bus  │
                        └──────┬───────┘
                               │
                               ▼
                        ┌──────────────┐
                        │Kafka Consumer│
                        └──────┬───────┘
                               │
                               ▼
                        ┌──────────────┐
                        │ SMTP / Email │
                        └──────────────┘
