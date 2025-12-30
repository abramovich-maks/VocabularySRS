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
- **User Authentication (JWT)** - stateless authentication using access tokens, token delivery via HTTP-only secure cookies and Authorization header

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
- Spring Security
- JWT (RSA)

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

## 🖥 Frontend

This project is **backend-focused**.

A minimal frontend exists only to manually test and demonstrate backend functionality
(authentication, dictionary management, and basic flows).

👉 Frontend repository:  
https://github.com/abramovich-maks/vocabulary-frontend

---

## 📘 Dictionary Enrichment

The application supports **optional word enrichment** (phonetics, audio, basic definitions).

External dictionary APIs are treated as **non-critical data sources**:
- absence of enrichment data does not affect core learning flows;
- users can add and review any words regardless of external API availability.

Dictionary enrichment is implemented as an **infrastructure-level concern** and does not influence the core SRS domain logic.

Currently, word enrichment data is fetched from the public Dictionary API  
https://dictionaryapi.dev/, which is based on Wiktionary data and may have limited coverage.

The system is designed so that this integration is **replaceable** and **non-blocking**.

---

## 🗺 Roadmap
- User accounts and personalization
- Learning statistics and analytics
- Adaptive learning algorithms
- Integration with Google Translate API

---

## ▶️ Running the Application

```bash
mvn clean install
mvn spring-boot:run
```

