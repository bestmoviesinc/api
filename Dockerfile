# Use an official OpenJDK runtime as a parent image
FROM openjdk:22

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot jar file
COPY target/bestmoviesinc.jar /app/bestmoviesinc.jar

# Expose port 8080 to the outside world
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "/app/bestmoviesinc.jar"]