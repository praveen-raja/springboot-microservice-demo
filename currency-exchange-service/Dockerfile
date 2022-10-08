FROM openjdk:17-jdk-slim-buster
LABEL org.opencontainers.image.authors="praveen2099636@gmail.com"
EXPOSE 8100
ADD target/currency-exchange-service.jar currency-exchange-service.jar
ENTRYPOINT ["java","-jar","/currency-exchange-service.jar"]
