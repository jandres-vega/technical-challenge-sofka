# Customer Person Microservice

Microservicio de gestión de clientes y personas.

## 🔧 Configuración

**Puerto:** `8000`  
**URL Base:** `http://localhost:8000`

## 🌍 Variables de Entorno
```yaml
server:
  port: 8000
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/myDb
    username: ${DB_USER:postgres}
    password: ${DB_PASSWORD:password}
    
```

## 🛣️ Endpoints

| Método | Endpoint                 | Descripción        |
|--------|--------------------------|--------------------|
| GET    | `/clientes`              | Listar clientes    |
| GET    | `/clientes/{customerId}` | Obtener cliente    |
| POST   | `/clientes`              | Crear cliente      |
| PUT    | `/clientes/{id}`         | Actualizar cliente |
| DELETE | `/clientes/{customerId}` | Eliminar cliente   |

---

## 📊 Modelo Cliente

```json
{
  "name": "Jose Lema",
  "gender": "Masculino",
  "age": 35,
  "identification": "1234567890",
  "address": "Otavalo sn y principal",
  "phone": "098254785",
  "customerId": "JOSE001",
  "password": "1234",
  "status": true
}
```

---

## 🚀 Iniciar Servicio

```bash
cd customer-person-msv
mvn spring-boot:run
```

Verificar: [http://localhost:8000/clientes](http://localhost:8000/clientes)

---

## 🧪 Pruebas

```bash
mvn test
```

Incluye:
- `CustomerTest.java` → Pruebas unitarias
- Validaciones de modelo
- Herencia de `Person`

---

## 🏗️ Arquitectura

- **Hexagonal Architecture**
- **CQRS Pattern**
- **Repository Pattern**
- **Domain-Driven Design (DDD)**

---

## 📁 Estructura

```text
src/main/java/
├── application/        # DTOs, Services, UseCases
├── domain/             # Models, Repository interfaces
└── infrastructure/     # Controllers, JPA, Exceptions
```
