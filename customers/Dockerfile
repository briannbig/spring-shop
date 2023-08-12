FROM openjdk:17-slim

RUN  mkdir -p /opt/spring-shop/customers

COPY ./target/customers-1.0-SNAPSHOT.jar /opt/spring-shop/customers/

WORKDIR /opt/spring-shop/customers

EXPOSE 9000 0

ENTRYPOINT ["java", "-jar", "customers-1.0-SNAPSHOT.jar"]