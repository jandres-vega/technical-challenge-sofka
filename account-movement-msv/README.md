# Account Movement Microservice

Microservicio de gestión de cuentas y movimientos bancarios.

---

## 🔧 Configuración

- **Puerto:** `9000`
- **URL Base:** `http://localhost:9000`

---

## 🌍 Variables de Entorno

```yaml
server:
  port: 9000
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/banking_system
    username: ${DB_USER:postgres}
    password: ${DB_PASSWORD:password}
feign:
  client:
    config:
      customer-person-msv:
        url: http://localhost:8000
```

---

## 🛣️ Endpoints

### Cuentas

| Método | Endpoint        | Descripción     |
|--------|-----------------|-----------------|
| GET    | `/cuentas`      | Listar cuentas  |
| GET    | `/cuentas/{id}` | Obtener cuenta  |
| POST   | `/cuentas`      | Crear cuenta    |
| DELETE | `/cuentas/{id}` | Eliminar cuenta |

### Movimientos

| Método | Endpoint       | Descripción           |
|--------|----------------|-----------------------|
| GET    | `/movimientos` | Listar movimientos    |
| POST   | `/movimientos` | Crear movimiento      |

### Reportes

| Método | Endpoint     | Descripción                  |
|--------|--------------|------------------------------|
| GET    | `/reportes`  | Reporte por cliente/fechas   |

---

## 📊 Modelos

### Crear Cuenta

```json
{
  "accountNumber": "478758",
  "accountType": "Ahorro",
  "initialBalance": 2000,
  "customerId": "JOSE001"
}
```

### Crear Movimiento

```json
{
  "accountNumber": "478758",
  "movementType": "Retiro",
  "value": -575
}
```

### Generar Reporte

```http
GET /reportes?customerId=MARIA001&startDate=2025-09-19T09:37:00&endDate=2025-09-19T09:39:00
```

---

## 🚀 Iniciar Servicio

```bash
cd account-movement-msv
mvn spring-boot:run
```

Verificar: [http://localhost:9000/cuentas](http://localhost:9000/cuentas)

---

## ⚠️ Validaciones Especiales

- **Saldo Insuficiente:** Error `"Saldo no disponible"`
- **Cuentas Únicas:** Número de cuenta no duplicado
- **Comunicación:** Feign Client con `customer-person-msv`

---

## 🧪 Pruebas

```bash
mvn test
```

Incluye:
- `MovementControllerTest.java` → Pruebas de integración
- Validación de saldo insuficiente
- Creación de movimientos exitosos

---

## 🏗️ Arquitectura

- **Hexagonal Architecture**
- **CQRS Pattern**
- **Feign Client** para comunicación
- **Global Exception Handler**

---

## 📁 Estructura

```text
src/main/java/
├── application/        # DTOs, Services, UseCases  
├── domain/             # Models, Repository interfaces
└── infrastructure/     # Controllers, JPA, External clients
```

---

## 🔗 Dependencias Externas

- **Customer Service** → Para obtener datos de clientes
- **PostgreSQL** → Base de datos principal