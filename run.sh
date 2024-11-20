#!/bin/bash

# Habilitar salida de errores si ocurre un fallo
set -e

# Mensaje inicial
echo "🚀 Iniciando el backend y MySQL con Docker Compose..."

# Generar el archivo JAR del backend
echo "🔨 Construyendo el backend con Maven..."
./mvnw clean package -DskipTests

# Verificar si el archivo JAR fue generado
if [ -f target/final-0.0.1-SNAPSHOT.jar ]; then
    echo "✅ Archivo JAR generado con éxito."
else
    echo "❌ No se pudo generar el archivo JAR. Revisa el log de Maven."
    exit 1
fi

# Construir y ejecutar los contenedores Docker
echo "🐳 Construyendo y ejecutando contenedores Docker..."
docker compose up --build -d

# Verificar si los contenedores están corriendo
echo "📋 Verificando contenedores activos..."
docker ps

# Mensaje final
echo "✅ Todo listo. Backend corriendo en http://localhost:8080"
