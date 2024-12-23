
# Spring Boot Application with MongoDB and Docker

This repository contains a Spring Boot application that connects to a MongoDB database and includes Docker support for easy deployment.

---

## 🚀 Features

- RESTful APIs built with Spring Boot.
- MongoDB as the database for persistence.
- Docker support for containerized deployment.
- Easy configuration with environment variables.

---

## 🛠 Prerequisites

Before running the application, ensure you have the following installed:

1. **Java Development Kit (JDK)**: Version 17 or later.
    - [Download JDK](https://adoptium.net/)
2. **Maven**: For building the project.
    - [Download Maven](https://maven.apache.org/download.cgi)
3. **Docker**: For containerization.
    - [Install Docker](https://www.docker.com/get-started)
4. **MongoDB**: If running locally.
    - [Install MongoDB](https://www.mongodb.com/docs/manual/installation/)

---

## 📂 Project Structure

```
.
├── src/                  # Application source code
├── target/               # Compiled output (generated after build)
├── Dockerfile            # Docker configuration for the application
├── pom.xml               # Maven dependencies and build configuration
├── README.md             # Project documentation
└── .gitignore            # Ignored files for Git
```

---

## ⚙️ Configuration

### 1. **MongoDB Setup**

#### Option 1: Local MongoDB
If you have MongoDB installed locally, ensure it's running on the default port `27017`. Update `application.properties` or `application.yml`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/your-database-name
```

#### Option 2: MongoDB Docker Container
Run MongoDB using Docker:
```bash
docker run -d -p 27017:27017 --name mongodb mongo
```

### 2. **Environment Variables**
You can set environment variables to configure the application:

- `SPRING_PROFILES_ACTIVE`: Set the Spring profile (e.g., `dev`, `prod`).
- `MONGO_URI`: MongoDB connection string.

---

## 🏗️ Build and Run

### 1. **Clone the Repository**
```bash
git clone https://github.com/thusithz/spring-boot-with-mongodb.git
cd your-repo-name
```

### 2. **Build the Application**
Use Maven to build the application:
```bash
mvn clean package
```

### 3. **Run the Application Locally**
Run the application with Maven:
```bash
mvn spring-boot:run
```

---

## 🐳 Docker Instructions

### 1. **Build Docker Image**
```bash
docker build -t spring-boot-app .
```

### 2. **Run Docker Container**
Run the Spring Boot application:
```bash
docker run -p 8080:8080 --name spring-boot-app spring-boot-app
```

### 3. **Run MongoDB and Spring Boot Together**
Use Docker Compose (optional):
Create a `docker-compose.yml` file:
```yaml
version: '3.8'
services:
  mongodb:
    image: mongo
    container_name: mongodb
    ports:
      - "27017:27017"
  spring-boot-app:
    build: .
    ports:
      - "8080:8080"
    environment:
      - SPRING_DATA_MONGODB_URI=mongodb://mongodb:27017/your-database-name
    depends_on:
      - mongodb
```

Run:
```bash
docker-compose up
```

---

## 📋 API Endpoints

| Method | Endpoint          | Description            |
|--------|-------------------|------------------------|
| GET    | `/api/v1/persons` | Fetch all persons      |
| POST   | `/api/v1/person`  | Create a new person    |
| PUT    | `/api/v1/person`  | Update an existing one |
| DELETE | `/api/v1/person`  | Delete a person        |

---

## 🔍 Testing the API

Use a tool like [Postman](https://www.postman.com/) or [curl](https://curl.se/) to test the endpoints:

```bash
curl -X GET http://localhost:8080/api/v1/persons
```

---

## 🛠 Troubleshooting

1. **MongoDB connection error:**
    - Ensure MongoDB is running and accessible at the specified `MONGO_URI`.

2. **Port already in use:**
    - Stop any application running on port `8080` or change the exposed port.

---
