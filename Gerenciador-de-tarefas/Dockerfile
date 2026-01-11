# Usa o JDK 17 oficial da Eclipse Temurin (funciona no Docker Hub)
FROM eclipse-temurin:17-jdk


# Copia o JAR gerado pelo Maven
COPY target/*.jar app.jar

WORKDIR app.jar

RUN mvn clean install

EXPOSE 8080
# Roda a aplicação
CMD ["java", "-jar", "/app.jar"]

