FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/docker-user.jar target/app.jar
EXPOSE 8010
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=local","target/app.jar"]
