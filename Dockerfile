# Usar uma imagem leve do Java
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
# Copia o arquivo JAR que o IntelliJ gera quando você dá o build
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]