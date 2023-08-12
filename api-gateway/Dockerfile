FROM openjdk:17-slim

RUN  mkdir -p /opt/spring-shop/api-gateway

COPY ./target/api-gateway-1.0-SNAPSHOT.jar /opt/spring-shop/api-gateway/

WORKDIR /opt/spring-shop/api-gateway

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "api-gateway-1.0-SNAPSHOT.jar"]