FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /src
COPY pom.xml .
RUN mvn -q dependency:go-offline
COPY src src
RUN mvn -q package dependency:copy-dependencies
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /src/target /app/target
EXPOSE 8080
CMD ["sh", "-c", "java -cp 'target/classes:target/dependency/*' example.Application"]
