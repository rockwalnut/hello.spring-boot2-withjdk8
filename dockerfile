FROM openjdk:8-jdk-alpine
COPY target/hello.jar /app.jar
RUN  ls -la .
RUN  pwd
RUN  apk add --no-cache curl
EXPOSE 8080/tcp
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.demo.DemoApplication"]

