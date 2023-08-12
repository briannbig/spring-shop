FROM openjdk:17-slim

RUN  mkdir -p /opt/spring-shop/products

COPY ./target/products-1.0-SNAPSHOT.jar /opt/spring-shop/products/

WORKDIR /opt/spring-shop/products

EXPOSE 9000 0

ENTRYPOINT ["java", "-jar", "products-1.0-SNAPSHOT.jar"]