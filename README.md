# 🏨 Villa Avougjagi - Pensionat & Bokningssystem

Ett modernt Pensionat och bokningssystem byggt med **Spring Boot v3.5.0 / Java 17**.
Projektet använder **Spring MVC**, **Spring Data JPA**, **Thymeleaf**, **MySQL/H2** och en egen hotell design inspirerad av hotell sidor.

---

# ✨ Funktioner

## 👤 Kunder
- Skapa, lista, uppdatera och ta bort kunder
- Validering av:
  - namn
  - e-post
  - telefonnummer
- Kunder med aktiva bokningar kan inte raderas

---

## 🛏️ Rum
- Skapa och hantera rum
- Enkelrum och dubbelrum
- Extrasängar
- Pris per natt
- Automatisk kapacitetsberäkningar
- Rum med bokningar kan inte tas bort

---

## 📅 Bokningar
- Skapa bokningar
- Ändra bokningar
- Avboka bokningar
- Kontroll mot dubbelbokningar
- Kontroll att:
  - utcheckning är efter incheckning
  - rum har rätt kapacitet
  - obligatoriska fält är ifyllda
 
---

## 🎨 Frontend
- Responsiv hotell design
- Thymeleaf templates
- Modern hero-section
- JavaScript confirmation innan borttagning
- Anpassad CSS design

---

# 🧠 Extra funktioner

Funktioner som implementerades utöver grundkraven:

- Dynamisk sökning av rum
- Kapacitetskontroll för antal gäster
- Extrasängar för dubbelrum
- Flash meddelanden vid CRUD-operationer
- JavaScript confirmation vid borttagning
- DTO lager mellan frontend och backend
- Tester med JUnit 5 och Mockito
- Code First struktur med entities först

---

# 🛠️ Tekniker

| Teknik | Beskrivning |
|---|---|
| Java 17 | Backend |
| Spring Boot v3.5.0 | Framework |
| Spring MVC | Webb |
| Spring Data JPA | Databashantering |
| Hibernate | ORM |
| Thymeleaf | Templates |
| H2 / MySQL | Databas |
| Lombok | Renare kod |
| JUnit 5 | Tester |
| Mockito | Mockade tester |
| HTML/CSS/JavaScript | Frontend |

---

# 📂 Projektstruktur

```text
src
├── main
│   ├── java
│   │   └── Pensionaten
│   │       ├── controller
│   │       ├── service
│   │       ├── repositories
│   │       ├── models
│   │       ├── dto
│   │       ├── config
│   │       └── PensionatenApplication.java
│   │
│   └── resources
│       ├── templates
│       │   ├── customers
│       │   ├── bookings
│       │   └── room
│       │
│       ├── static
│       │   ├── css
│       │   ├── js
│       │   └── images
│       │
│       └── application.properties
│
└── test
    └── java
        └── Pensionaten
            └── service
                ├── BookingServiceTest.java
                ├── CustomerServiceTest.java
                └── RoomServiceTest.java
```

---

## Starta projektet

Kör:

``` bash
mvn spring-boot-run
```

eller starta:

```text
PensionatenApplication.java
```

som en Spring Boot applikation i IntelliJ.

---

# 🗄️ Databas

Projektet kan köras med:

## H2 databas direkt i IntelliJ

Exempel:

```properties
spring.datasource.url=jdbc:h2:file:./data/villa-avougjagi-db
```

H2 konsol:

```text
http://localhost:8080/h2-console
```

---

# 📌 Viktiga URL:er

| URL | Beskrivning |
|---|---|
| `/` | Startsida |
| `/customers` | Hantera gäster |
| `/rooms` | Hantera rum |
| `/bookings` | Visa bokningar |
| `/bookings/new` | Skapa bokning |

---

# ✅ Validering

Projektet använder Jakarta Validation.

Exempel:
- obligatoriska fält
- giltig e-post
- telefonnummer
- datumkontroll
- kapacitetskontroll
- skydd mot dubbelbokningar

Valideringsfel visas direkt i formulären.

---

# 🧪 Tester

Projektet innehåller tester för:

- `RoomService`
- `CustomerService`
- `BookingService`

Tester verifierar bland annat:
- datumvalidering
- dubbelbokningar
- borttagning av kunder/rum
- lediga rum
- kapacitetskontroll

Kör tester:

```bash
mvn test
```

---

# 📸 Bilder

## Startsida

<img width="1902" height="907" alt="image" src="https://github.com/user-attachments/assets/f360cc69-3836-4b75-ab86-9ec4047fe887" />

---

## Gästhantering

<img width="1918" height="907" alt="image" src="https://github.com/user-attachments/assets/54f07016-b77e-4f28-b6f1-92f8a98cb79b" />

---

## Rum

<img width="1918" height="910" alt="image" src="https://github.com/user-attachments/assets/5a366d8f-c166-46de-9c77-c893d55dced7" />

---

## Bokningar

<img width="1918" height="910" alt="image" src="https://github.com/user-attachments/assets/4b573bb9-8e6a-43ad-b122-aa40ad561afd" />

---

## Bokningssytem

<img width="1898" height="911" alt="image" src="https://github.com/user-attachments/assets/f13b9e3a-4894-4739-943d-4ce041e8690d" />

---

# 👨‍💻 Utvecklare

Made by:

- Alexander Zeljic
- Boris Ivis

---

# 📖 Reflektion

Målet med projektet var att bygga ett realistiskt pensionat och bokningssytem med fokus på:

- MVC arkitektur
- validering
- databasdesign
- användarvänlighet
- bokningslogik
- modern frontend design

Projektet utvecklades med Code First principen där entities och databasen först innan resterande lager implementerades.

---
