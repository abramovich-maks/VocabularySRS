# Vocabulary SRS

A backend‑focused application for learning English vocabulary using a **Spaced Repetition System (SRS)**.
Users maintain their own vocabulary: they add words with translations, and the system generates a daily test based on the word creation date and the results of previous tests.

---

## 🚀 Project Overview

The application automatically:

- selects daily vocabulary items;
- generates learning and review tasks;
- builds a **daily test** for the user;
- adapts repetition intervals based on learning history.

The core idea is to model the **learning process itself as domain logic**, not just data storage.

---

## 🧩 Key Features

- **Daily Words Selector** - selects words scheduled for the current day
- **Learning Task Generator** - creates tasks based on progress and past results
- **Daily Test** - generates a daily vocabulary test for the user
- **SRS Logic** - interval‑based repetition strategy
- **Integration Tests** - end‑to‑end business scenario coverage

---

## 🛠 Tech Stack

- Java 17
- PostgreSQL
- Spring Boot
- Maven
- JUnit 5
- Testcontainers
- REST (JSON)
- Lombok

---

## 🧪 Testing Strategy

The project focuses on **integration testing of real business scenarios**:

- tests are executed through application facades
- real database setup via Testcontainers
- validation of complete user flows, including:
  - daily word selection
  - test generation
  - result retrieval

---

## 🗺 Roadmap

- Frontend (React)
- JWT‑based authentication
- User accounts and personalization
- Learning statistics and analytics
- Adaptive learning algorithms
- Integration with https://dictionaryapi.dev/
- Integration with Google Translate API

---

## ▶️ Running the Application

```bash
mvn clean install
mvn spring-boot:run
```

