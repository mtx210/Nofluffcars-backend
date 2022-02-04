FROM openjdk:8
ADD target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-Ddbhost=nofluffcars_db","-Ddbport=3306","-jar","/app.jar"]