# Build stage
FROM maven:3.8.8-amazoncorretto-17 AS build
LABEL authors="Johan Alvarado"

# Create folders
RUN mkdir -p /home/app/application
RUN mkdir -p /home/app/application/configuration
RUN mkdir -p /home/app/application/core
RUN mkdir -p /home/app/application/entry-point
RUN mkdir -p /home/app/application/data-provider

# Copy files
COPY pom.xml /home/app/
COPY application/pom.xml /home/app/application/
COPY application/configuration /home/app/application/configuration
COPY application/core /home/app/application/core
COPY application/entry-point /home/app/application/entry-point
COPY application/data-provider /home/app/application/data-provider

# Install all modules in the local repository
RUN mvn -f /home/app/pom.xml clean install

# Package the configuration module
RUN mvn -f /home/app/pom.xml clean compile package

# Expose the default WildFly port (or change this to your application's port)
EXPOSE 8080

# Define the command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/home/app/application/configuration/target/configuration-1.0-SNAPSHOT.jar"]