FROM openjdk:17-jdk-slim-buster
LABEL org.opencontainers.image.authors="praveen2099636@gmail.com"
EXPOSE 8765
ADD target/api-gateway.jar api-gateway.jar
ENTRYPOINT ["java","-jar","/api-gateway.jar"]
