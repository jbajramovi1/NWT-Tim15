FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/docker-booking.jar target/app.jar
ENTRYPOINT ["java","-jar","target/app.jar"]
EXPOSE 8085