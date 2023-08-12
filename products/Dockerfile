FROM openjdk:17-slim

ADD ./target/products-*.jar app.jar

EXPOSE 9000 0

ENTRYPOINT ["java", "-jar", "app.jar"]