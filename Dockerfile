FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/onlineexamination-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9096

ENTRYPOINT ["java", "-jar", "app.jar"]