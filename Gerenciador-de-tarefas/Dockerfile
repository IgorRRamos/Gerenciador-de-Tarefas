FROM eclipse-temurin:17-jdk-alpine
#Imagem base com o JAVA

WORKDIR /app
#Diretorio de trabalho dentro do container

COPY target/*.jar app.jar
#Copia o jar gerado para o container

EXPOSE 8080
#Expoe a porta 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
#Comando para rodar a aplicação