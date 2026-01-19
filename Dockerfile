# Use stable Java (recommended for Spring Boot on cloud)
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the built JAR file
COPY target/*.jar app.jar

# Expose port (Render will override with PORT env var)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
