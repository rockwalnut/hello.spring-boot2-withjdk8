FROM openjdk:8-jdk-alpine
COPY target/hello-mvn-obj.jar /app.jar
RUN  ls -la .
RUN  pwd
RUN  apk add --no-cache curl
EXPOSE 8080/tcp
ENTRYPOINT ["java", "-XX:MaxRAM=1024m", "-Xms512m", "-Xmx1024m", "-XX:NewRatio=4", "-XX:+UseG1GC", "-verbose:gc", "-Dsun.rmi.dgc.client.gcInterval=300000", "-Dsun.rmi.dgc.server.gcInterval=300000", "-jar", "/app.jar"]
