FROM maven:3.6.3-jdk-11 AS MAVEN_BUILD

COPY ./ ./
RUN mvn clean package
FROM openjdk:11.0.7-jdk-slim
COPY --from=MAVEN_BUILD /target/app-2.jar /app-2.jar

CMD ["java", "-jar", "/app-2.jar"]