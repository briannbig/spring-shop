FROM openjdk:17-slim


ADD ./target/customers-*.jar app.jar

EXPOSE 9000 0

ENTRYPOINT ["java", "-jar", "app.jar"]