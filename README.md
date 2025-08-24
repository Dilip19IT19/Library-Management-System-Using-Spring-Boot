# Library Management System (LIBMS) - Spring Boot GraphQL

A modern, efficient **Library Management System** built with **Spring Boot**, **Spring GraphQL**, and **PostgreSQL**. This project demonstrates a clean, scalable architecture using GraphQL APIs for managing Books, Authors, and Categories with features like advanced pagination and analytics.

---

## Features

- Flexible API using **GraphQL** with queries and mutations
- Manage **Books**, **Authors**, and **Categories** with rich entity relationships
- Perform **CRUD operations**
- Support for custom analytics queries (e.g., book counts per category)
- Pagination support with sorting options via GraphQL queries
- Leveraging **Spring Data JPA** with native and JPQL queries
- PostgreSQL backing database for data persistence
- Configuration via YAML with environment-friendly settings

---

## Technology Stack

- Java 17+
- Spring Boot 3.x
- Spring for GraphQL
- Spring Data JPA & Hibernate
- PostgreSQL
- Maven build tool
- Lombok for boilerplate reduction

---

## Getting Started

### Prerequisites

- Java 17 or later
- PostgreSQL database instance
- Maven 3.6 or later

### Setup

1. **Clone the repository:**

git clone https://github.com/Dilip19IT19/Library-Management-System-Using-Spring-Boot.git
cd Library-Management-System-Using-Spring-Boot

text

2. **Configure database connection:**

Update `src/main/resources/application.yml` with your PostgreSQL details:

spring:
datasource:
url: jdbc:postgresql://your-db-host:5432/your-db-name
username: your-db-user
password: your-db-password

text

3. **Build and run the application:**

mvn clean install
mvn spring-boot:run

text

4. **Access GraphQL Playground:**

Navigate to `http://localhost:8080/LIBMS` (or as configured in your `application.yml`) to interact with the GraphQL API.

---

## Example GraphQL Queries

### Get all categories paginated
```
query {
getAllPaginatedCategories(pageableCategoryInput: {page: 0, size: 5, sortBy: "name", ascending: true}) {
categories {
id
name
description
}
pageNumber
pageSize
totalElements
totalPages
}
}

text
```
### Get books count per category
```
query {
getBooksCountPerCategory {
count
name
}
}

text
```
### Add a new category

```

mutation {
saveCategory(category: { name: "Science Fiction", description: "Futuristic books" }) {
id
name
description
}
}

```
## Project Structure
```
src/
└── main/
├── java/com/DiYukti/LIBMS/
│ ├── controller/ # GraphQL Controllers
│ ├── dto/ # Data Transfer Objects for API responses
│ ├── entity/ # JPA Entities mapping database tables
│ ├── repository/ # Spring Data repositories
│ ├── service/ # Business logic services
│ └── LibmsApplication.java # Main Spring Boot application class
└── resources/
├── application.yml # Configuration file
└── graphql/ # GraphQL schema files

