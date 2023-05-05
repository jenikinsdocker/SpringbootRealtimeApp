FROM openjdk:17
EXPOSE 8080
ADD target/springbootrealtime-app.jar springbootrealtime-app.jar
ENTRYPOINT ["java","-jar","/springbootrealtime-app"]