FROM eclipse-temurin:19-alpine

RUN mkdir -p /var/logs
VOLUME /var/logs
EXPOSE 8080

WORKDIR /backend
ARG JAR_FILE=./target/*.jar
CMD PWD
ADD ${JAR_FILE} fti.jar

ENTRYPOINT ["java","-jar","fti.jar"]