FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/gescor-kafka-*.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
