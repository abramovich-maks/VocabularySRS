# Vocabulary SRS

A backend-focused application for learning English vocabulary using a **Spaced Repetition System (SRS)**.

Users maintain their own vocabulary by adding words with translations.  
The system generates learning tasks **on demand** using a **user-driven Spaced Repetition System**.  
Words are scheduled dynamically based on previous test results and individual repetition intervals.

---

## 🚀 Project Overview

The application models the **learning process itself as domain logic**, not just data storage.

It:

- dynamically schedules vocabulary based on learning performance;
- generates learning and review tasks on demand;
- builds a **daily test snapshot** for the user;
- adapts repetition intervals using an adaptive SRS algorithm.

There are **no schedulers** - learning tasks are created only when the user explicitly requests a daily test.

---

## 🧩 Key Features

- **Adaptive Learning Algorithm** - dynamically adjusts repetition intervals based on user performance
- **User-driven SRS** - learning tasks are generated only when requested by the user
- **On-demand Learning Task Generator** - selects all words that are due for review (`nextReviewDate ≤ today`)
- **Daily Test** - generates a user-specific test snapshot for a given day
- **Integration Tests** - end-to-end verification of real business scenarios
- **User Authentication (JWT)** - stateless authentication using RSA-signed tokens

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

## 🧪 Testing Strategy

The project focuses on **integration testing of real business scenarios**:

- tests are executed through application facades;
- real database setup via Testcontainers;
- validation of complete user flows, including:
  - adaptive word scheduling;
  - on-demand test generation;
  - result evaluation and progress updates.

Tests act as **executable specifications** of the SRS behavior.

---

## 🧠 Adaptive Learning

The application implements a fully **adaptive, user-driven Spaced Repetition System**.

Learning tasks are generated only when the user requests a daily test.  
If no words are due for review, **no test is generated** — this is a valid and expected state.

Repetition intervals are recalculated after each test based on user answers.

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
- Integration with Google Translate API

---

## ▶️ Running the Application

```bash
mvn clean install
mvn spring-boot:run
```

