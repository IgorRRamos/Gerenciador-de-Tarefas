# Usando imagem do Maven + JDK 17
FROM maven:3.9.5-eclipse-temurin-17 AS build

# Diretório da aplicação dentro do container
WORKDIR /app

# Copia o pom.xml e baixa dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o restante do código
COPY src ./src

# Compila a aplicação
RUN mvn clean package -DskipTests

# Segunda etapa: imagem menor para rodar a aplicação
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copia o jar da etapa de build
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta do Spring Boot
EXPOSE 8080

# Comando para rodar
CMD ["java", "-jar", "app.jar"]
