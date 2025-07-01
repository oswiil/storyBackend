
---

## 📦 Cómo levantar el entorno

### 1. Ejecutar el docker-compose.yml
```bash
docker compose up
```
## 🌐 Servicios

| Servicio        | Dirección en navegador                         | Comentario                                     |
| --------------- | ---------------------------------------------- | ---------------------------------------------- |
| Adminer         | [http://localhost:8000](http://localhost:8000) | Acceso a PostgreSQL vía web                    |
| Spring Boot App | [http://localhost:8081](http://localhost:8081/swagger-ui/index.html#/) | Si habilitas el servicio `app`                 |
| PostgreSQL      | N/A desde host local, salvo que abras `5432`   | Internamente accesible como `db-postgres:5432` |
