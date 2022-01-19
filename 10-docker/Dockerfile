# Build, package and run the application in stages
FROM maven:3-eclipse-temurin-11-alpine AS builder
WORKDIR /usr/src/app
COPY pom.xml .
RUN mvn -B dependency:go-offline
COPY . .
RUN mvn package

FROM eclipse-temurin:11-alpine
WORKDIR /app
COPY --from=builder /usr/src/app/target/10-docker-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/10-docker-0.0.1-SNAPSHOT.jar"]
