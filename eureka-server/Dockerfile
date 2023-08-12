FROM openjdk:17-slim

RUN  mkdir -p /opt/spring-shop/eureka-server

COPY ./target/eureka-server-1.0-SNAPSHOT.jar /opt/spring-shop/eureka-server/

WORKDIR /opt/spring-shop/eureka-server

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "eureka-server-1.0-SNAPSHOT.jar"]