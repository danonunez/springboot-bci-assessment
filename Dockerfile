FROM maven:3.8.1-openjdk-17-slim AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

FROM openjdk:17 AS app
ARG JAR_FILE=/usr/src/app/target/*.jar
COPY --from=build ${JAR_FILE} /usr/app/springboot-bci-assessment.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/springboot-bci-assessment.jar"]