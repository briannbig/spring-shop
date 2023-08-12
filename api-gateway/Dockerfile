FROM openjdk:17-slim

ADD ./target/api-gateway-*.jar app.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "app.jar"]