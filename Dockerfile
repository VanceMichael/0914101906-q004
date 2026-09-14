FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY . .
RUN mkdir -p target/classes && javac -d target/classes src/main/java/example/Application.java
EXPOSE 8080
CMD ["java", "-cp", "target/classes", "example.Application"]
