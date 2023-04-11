FROM adoptopenjdk/openjdk11:latest
RUN mkdir /opt/app
COPY target/spring-boot-rest-1.0.0-SNAPSHOT.jar /opt/app
CMD ["java", "-jar", "/opt/app/spring-boot-rest-1.0.0-SNAPSHOT.jar"]
