# Sistema de Gestión Bancaria - Arquitectura Microservicios

Sistema bancario desarrollado con arquitectura de microservicios, implementando patrones **DDD**, **CQRS** y principios **SOLID**.

## 🏗️ Arquitectura

- **customer-person-msv**: Gestión de clientes y personas (Puerto `8000`)
- **account-movement-msv**: Gestión de cuentas y movimientos (Puerto `9000`)

## 🚀 Tecnologías

- Java 17
- Spring Boot 3.x
- PostgreSQL
- Maven
- Feign Client (comunicación entre microservicios)

## 🗄️ Base de Datos

```bash
# Crear base de datos PostgreSQL
createdb banking_system

# Ejecutar script de inicialización
psql banking_system < BaseDatos.sql

```
## ⚡ Inicio Rápido
### Terminal 1 - Customer Service:
```bash
cd customer-person-msv
mvn spring-boot:run
```

### Terminal 2 - Account Service:
```bash
cd account-movement-msv
mvn spring-boot:run
```
### Validar con Postman
Importar colección: `Reto-Tecnico.postman_collection.json`

---

## 🌐 URLs de los Microservicios

- **Customer Service**: http://localhost:8000
- **Account Service**: http://localhost:9000

---

## ⚙️ Variables de Entorno Globales

- DB_USER=postgres
- DB_PASSWORD=password
- DB_HOST=localhost
- DB_PORT=5432
- DB_NAME=banking_system

## 📂 Estructura del Proyecto

```text
├── customer-person-msv/          # Microservicio Clientes
├── account-movement-msv/         # Microservicio Cuentas
├── BaseDatos.sql                 # Script BD
├── Reto-Tecnico.postman_collection.json
└── README.md

---

## 🧪 Ejecutar Todas las Pruebas

```bash
mvn test  # Desde raíz
```

---

## 📚 Documentación Detallada

- **Customer Person Microservice**
- **Account Movement Microservice**