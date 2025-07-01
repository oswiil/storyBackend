#!/bin/sh
echo "⏳ Esperando a que PostgreSQL esté listo..."

until pg_isready -h db-postgres -p 5432 -U myuser; do
  echo "⏱️ Esperando..."
  sleep 2
done

echo "✅ PostgreSQL está listo. Arrancando app..."
exec java -jar app.jar
