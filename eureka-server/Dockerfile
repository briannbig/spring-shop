FROM openjdk:17-slim

ADD ./target/eureka-server-*.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "app.jar"]