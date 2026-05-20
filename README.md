# 📚 Accessible Reading List (ARL) – Backend Foundation

## 📌 Course Information
- Course: STIWK2124 Web Engineering
- Semester: A252 (Feb 2025/2026)
- Assignment: Assignment 1 – CLO2 Backend Development
- Title: Accessible Reading List Backend
- Database: MySQL (arl_db)
- Framework: Spring Boot 3
- Language: Java

---

## 📖 1. Project Overview

The Accessible Reading List (ARL) backend is a RESTful API system that allows users to manage reading materials such as books and articles.

### Features:
- CRUD operations (Create, Read, Update, Delete)
- Search functionality (q parameter)
- Pagination support
- Input validation
- MySQL database integration
- RESTful API design

---

## ⚙️ 2. Technologies Used

- Java 25
- Spring Boot
- Spring Web
- Spring Data JPA (Hibernate)
- Spring Validation
- Spring Security (basic configuration)
- MySQL Database
- Maven
- Postman (testing)

---

## 🗄️ 3. Database Setup

### 3.1 Create Database

```sql
CREATE DATABASE arl_db;
```

### 3.2 Create Table

```sql
CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

## ⚙️ 4. Application Configuration

Update `application.properties`:

```properties
spring.application.name=reading-list

spring.datasource.url=jdbc:mysql://localhost:3306/arl_db
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

---

## 🚀 5. FULL SETUP & RUN GUIDE

### Step 1: Clone Project
```bash
git clone https://github.com/paktai-class/Assignment-1---GROUP-2-.git
cd reading-list
```

### Step 2: Setup MySQL
- Open XAMPP / MySQL Workbench
- Start MySQL service

Create database:
```sql
CREATE DATABASE arl_db;
```

---

### Step 3: Configure Project
- Open project in IntelliJ IDEA
- Go to `src/main/resources/application.properties`
- Set MySQL credentials:

```properties
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

---

### Step 4: Run Application
Run:
```
ReadingListApplication.java
```

Expected output:
```
Tomcat started on port 8080
```

---

### Step 5: Access Application (Browser / Postman)

Open browser:

```
http://localhost:8080/api/books
```

If security login is enabled, use:

- Username: `admin`
- Password: `admin123`

---



## 📡 6. REST API ENDPOINTS

### ➕ Create Book
```
POST /api/books
```

### 📄 Get All Books (Pagination)
```
GET /api/books?page=0&size=5
```

### 🔍 Search Books
```
GET /api/books?q=java
```

### 📖 Get Book by ID
```
GET /api/books/{id}
```

### ✏️ Update Book
```
PUT /api/books/{id}
```

### ❌ Delete Book
```
DELETE /api/books/{id}
```

## 🧪 7. Postman Testing Guide

### 📌 Base URL
http://localhost:8080/api/books

---

## 🔐 7.1 Authorization (IMPORTANT)

All `/api/books/**` endpoints are protected.

### In Postman:
1. Go to **Authorization tab**
2. Select:
   Type: Basic Auth
3. Enter:
   Username: admin  
   Password: admin123

✔ Required for ALL requests

---

## ➕ 7.2 Create Book (POST)
## 7.2.1 Create Book (POST)

POST http://localhost:8080/api/books

### Headers:
Content-Type: application/json  
Authorization: Basic Auth (admin / admin123)

### Body (raw → JSON):
{
"title": "Spring Boot Guide",
"author": "John Doe",
"category": "Programming",
"description": "Learn Spring Boot basics from zero to advanced"
}

---

## 7.2.2 Pagination (GET)
1️⃣ ➕ Add Sample Books First
Ensure you have at least 5–6 books in your database using multiple requests:

2️⃣ 📄 Get First Page (Books 1–3)
GET http://localhost:8080/api/books?page=0&size=3

3️⃣ 📄 Get Second Page (Books 4–6)
GET http://localhost:8080/api/books?page=1&size=3

4️⃣ 📄 Get Third Page (Books 7–9)
GET http://localhost:8080/api/books?page=2&size=3

🧠 Notes
- page=0 → First page
- page=1 → Second page
- page=2 → Third page
- size=3 → Items per page
- Pagination starts from 0
- Make sure you fill the Params key and value correctly in Postman:
    > Key: page → Value: 0
    > Key: size → Value: 3


## 📚 7.3 Get All Books (GET)

GET http://localhost:8080/api/books

✔ Supports pagination automatically

---

## 🔍 7.4 Search Books (GET)

GET http://localhost:8080/api/books?title=spring

✔ Case-insensitive search by title

---

## ✏️ 7.5 Update Book (PUT)

PUT http://localhost:8080/api/books/{id}

Example:
PUT http://localhost:8080/api/books/1

### Body (raw → JSON):
{
"title": "Spring Boot Advanced Guide",
"author": "John Doe",
"category": "Programming",
"description": "Updated content for advanced learning"
}

---

## ❌ 7.6 Delete Book (DELETE)

DELETE http://localhost:8080/api/books/{id}

Example:
DELETE http://localhost:8080/api/books/1

---

## 📊 8. Features Implemented

✔ RESTful CRUD API  
✔ MySQL Database Integration  
✔ Spring Security (Basic Auth)  
✔ Pagination Support  
✔ Search by title (case-insensitive)  
✔ Input Validation (@NotBlank)  
✔ Layered Architecture (Controller → Service → Repository)  
✔ Proper HTTP status handling  
✔ JSON-based communication

---

## 🧠 9. System Architecture

- Controller Layer → Handles HTTP requests & responses
- Service Layer → Business logic processing
- Repository Layer → Database interaction (JPA)
- Entity Layer → Data model mapping to MySQL

---

## ⚙️ 10. Setup Requirements

✔ MySQL must be running  
✔ Database name: arl_db  
✔ Port: 8080

Default login:
admin / admin123

---

## 👨‍💻 11. Author

Group 2 – STIWK2124 Web Engineering  
Semester A252 – Feb 2025/2026

---

## 📌 12. Important Notes

- Start MySQL before running Spring Boot
- If 401 Unauthorized → check Basic Auth
- If connection fails → check port 8080  
