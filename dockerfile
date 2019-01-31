# FROM openjdk:8-jre-alpine

# VOLUME /tmp

# ARG DEPENDENCY=target/dependency

# COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
# COPY ${DEPENDENCY}/META-INF /app/META-INF
# COPY ${DEPENDENCY}/BOOT-INF/classes /app

# EXPOSE 8989/tcp 30432/tcp
# ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.demo.DemoApplication"]


# --

FROM openjdk:8-jre-alpine
#CMD ["sh", "-c", "tail -f /dev/null"]
RUN  mkdir -p /opt/tomcat/logs/
RUN  ls -la .
RUN pwd target
#copy from local path to docker hub path
#COPY target/hello-mvn-obj-0.0.1-SNAPSHOT.jar /app.jar
COPY target/hello-mvn-obj-0.0.1-SNAPSHOT.jar /app.jar

RUN  apk add --no-cache curl
EXPOSE 8080/tcp
ENTRYPOINT ["java", "-XX:MaxRAM=1024m", "-Xms512m", "-Xmx1024m", "-XX:NewRatio=4", "-XX:+UseG1GC", "-verbose:gc", "-Dsun.rmi.dgc.client.gcInterval=300000", "-Dsun.rmi.dgc.server.gcInterval=300000", "-jar", "/app.jar"]
