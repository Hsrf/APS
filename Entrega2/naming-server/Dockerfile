FROM openjdk:12-alpine

RUN apk update && apk add curl

COPY /target/naming-server-0.0.1-SNAPSHOT.jar /naming-server-0.0.1-SNAPSHOT.jar 

CMD ["java", "-jar", "/naming-server-0.0.1-SNAPSHOT.jar"]
