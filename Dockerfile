# Stage 1: Build the application
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /workspace/app

# Copy maven executable and configuration from the backend folder
COPY app/backend/mvnw .
COPY app/backend/.mvn .mvn
COPY app/backend/pom.xml .

# Download dependencies (this step will be cached unless pom.xml changes)
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline -B

# Copy the source code
COPY app/backend/src src

# Build the application (skip tests for faster deployment)
RUN ./mvnw clean package -DskipTests

# Stage 2: Create the runtime image
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /workspace/app/target/*.jar app.jar

# Run the application
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "app.jar"]
