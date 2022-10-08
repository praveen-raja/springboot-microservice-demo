FROM openjdk:17-jdk-slim-buster
LABEL org.opencontainers.image.authors="praveen2099636@gmail.com"
EXPOSE 8761
ADD target/naming-server.jar naming-server.jar
ENTRYPOINT ["java","-jar","/naming-server.jar"]
