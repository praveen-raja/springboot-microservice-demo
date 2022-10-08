FROM openjdk:17-jdk-slim-buster
LABEL org.opencontainers.image.authors="praveen2099636@gmail.com"
EXPOSE 8000
ADD target/currency-conversion-service.jar currency-conversion-service.jar
ENTRYPOINT ["java","-jar","/currency-conversion-service.jar"]
