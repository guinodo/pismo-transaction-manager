FROM gradle:7.3.1-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle
WORKDIR /home/gradle
RUN gradle build

FROM openjdk:11-jre-slim
EXPOSE 8080
USER root
RUN mkdir /app
COPY build/libs/pismo-transaction-manager.jar /app/pismo-transaction-manager.jar
ENTRYPOINT exec java -jar /app/pismo-transaction-manager.jar
