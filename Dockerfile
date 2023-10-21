# Use an OpenJDK base image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/your-application.jar your-application.jar

# Expose the port your application runs on (adjust if needed)
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "your-application.jar"]
