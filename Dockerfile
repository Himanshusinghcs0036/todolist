FROM openjdk:8-jdk
RUN mkdir -p /usr/apps/
COPY tasktodo-0.0.1-SNAPSHOT.jar /usr/apps/tasktodo-0.0.1-SNAPSHOT.jar
EXPOSE 8080:8080
ENTRYPOINT ["java","-Xmx10240m","-jar","/usr/apps/tasktodo-0.0.1-SNAPSHOT.jar"]

