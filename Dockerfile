FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/*.jar smsriskservice.jar

EXPOSE 9001

ENTRYPOINT ["java","-jar","smsriskservice.jar"]