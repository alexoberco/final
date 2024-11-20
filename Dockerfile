# Usar una imagen base de Java 21
FROM openjdk:21-jdk-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR del backend al contenedor
COPY target/final-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8080 para la aplicación
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
