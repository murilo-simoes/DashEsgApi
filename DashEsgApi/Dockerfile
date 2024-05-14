FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
COPY . .

RUN apt-get install maven -y -DskipTests
RUN mvn clean install

FROM openjdk:21-jdk-slim

EXPOSE 8000

COPY --from=build /target/DashEshApi-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]