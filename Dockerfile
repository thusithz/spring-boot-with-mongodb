
FROM maven:3.8.5-openjdk-17-slim AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the jar file from the build stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

LABEL authors="thusitha kariyawasam"

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
