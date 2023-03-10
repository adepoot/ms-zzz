# Build stage
FROM maven:3.9.0-eclipse-temurin-17-alpine AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Package stage
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /home/app/target/ms-power-generator-0.0.1-SNAPSHOT.jar /home/app/target/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/app/target/app.jar"]
