FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean install -U

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/eureka-server-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]