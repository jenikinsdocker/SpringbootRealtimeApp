FROM openjdk:17
EXPOSE 8080
ADD target/Springbootrealtime-app.jar Springbootrealtime-app.jar
ENTRYPOINT ["java","-jar","/Springbootrealtime-app"]