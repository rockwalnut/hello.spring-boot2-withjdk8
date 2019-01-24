FROM openjdk:8-jdk-alpine
COPY target/hello-mvn-obj.jar /app.jar
RUN  ls -la .
RUN  pwd
RUN  apk add --no-cache curl
EXPOSE 8080/tcp
ENTRYPOINT ["java", "-jar", "/app.jar"]