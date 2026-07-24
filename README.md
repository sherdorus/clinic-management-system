# Clinic Management System

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen)
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED)
![MySQL](https://img.shields.io/badge/MySQL-8-4479A1)
![Redis](https://img.shields.io/badge/Redis-DC382D)
![Prometheus](https://img.shields.io/badge/Monitoring-Prometheus-E6522C)
![Grafana](https://img.shields.io/badge/Dashboard-Grafana-F46800)
![Loki](https://img.shields.io/badge/Logging-Loki-2F4050)

A Spring Boot REST API demonstrating backend development, production-style deployment, monitoring, centralized logging, and DevOps practices.

---

## Overview

Clinic Management System provides REST APIs for managing clinics, doctors, patients, appointments, visits, and medical records.

The project is designed not only as a CRUD application, but also as a demonstration of how a Spring Boot application can be deployed and operated in a production-like environment using containerization, monitoring, centralized logging, and automated deployment.

---

## Features

### Business Features

- Doctor Management
- Patient Management
- Specialty Management
- Appointment Scheduling
- Visit Management
- Medical Records
- Swagger / OpenAPI Documentation

### Production-Style Features

- Docker Compose Deployment
- Nginx Reverse Proxy
- HTTPS (Let's Encrypt)
- MySQL
- Redis

- Spring Boot Actuator
- Micrometer
- Prometheus Monitoring
- Grafana Dashboards
- Loki Log Aggregation
- Promtail Log Collection

- Automated MySQL Backups
- Docker Log Rotation
- GitHub Actions Deployment

> Health and management endpoints (`/actuator/*`) are intentionally kept internal and are not exposed publicly.

---

## Architecture

```text
                     Internet
                         │
                    HTTPS (443)
                         │
                      Nginx
                         │
               Spring Boot REST API
                  │              │
                  │              ├────────► Redis
                  │
                  ├──────────────► MySQL
                  │
                  ├── Actuator ──► Prometheus ──► Grafana
                  │
                  └── application.log
                           │
                       Promtail
                           │
                         Loki
                           │
                        Grafana
```

---

## Technology Stack

### Backend

- Java 21
- Spring Boot 3.5.0
- Spring Data JPA
- Hibernate
- Maven
- Lombok

### Database

- MySQL 8
- Redis

### Infrastructure

- Docker
- Docker Compose
- Nginx
- Let's Encrypt SSL

### Monitoring

- Spring Boot Actuator
- Micrometer
- Prometheus
- Grafana

### Logging

- Loki
- Promtail

### CI/CD

- GitHub Actions

---

## Live Demo

Live API

**https://clinic.ubucloud.cc**

Swagger UI

**https://clinic.ubucloud.cc/swagger-ui.html**

OpenAPI Specification

**https://clinic.ubucloud.cc/api-docs**

Grafana Dashboard (login required)

**https://grafana.clinic.ubucloud.cc**

---

## Monitoring

The application exposes operational metrics through Spring Boot Actuator.

Collected metrics include:

- JVM Heap Usage
- JVM Threads
- CPU Usage
- HTTP Request Metrics
- Database Connection Pool
- Application Health

Metrics are collected by Prometheus and visualized in Grafana.

---

## Centralized Logging

Application logs are written to log files and collected by Promtail.

Logs are stored in Loki and can be searched through Grafana.

---

## Quick Start

### Clone Repository

```bash
git clone https://github.com/sherdorus/clinic-management-system.git

cd clinic-management-system
```

### Create Database

```sql
CREATE DATABASE clinicdb;
```

### Configure Database

Update:

```text
src/main/resources/application.yaml
```

Example:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/clinicdb
    username: your_username
    password: your_password
```

### Run Application

```bash
mvn spring-boot:run
```

### Open Swagger UI

```text
http://localhost:8080/swagger-ui.html
```

---

## Sample Data

Import sample records:

```bash
mysql -u your_username -p clinicdb < src/main/resources/db/clinic_test_data.sql
```

---

## Project Structure

```text
src
├── main
│   ├── java
│   │   └── io
│   │       └── sherdor
│   │           └── clinicmanagementsystem
│   │               ├── config
│   │               ├── controller
│   │               ├── dto
│   │               ├── entity
│   │               ├── enums
│   │               ├── repository
│   │               ├── service
│   │               └── ClinicManagementApplication.java
│   │
│   └── resources
│       ├── db
│       └── application.yaml
```

---

## Roadmap

- JWT Authentication
- Role-Based Authorization
- Email Notifications
- Audit Logging
- File Uploads
- Integration Tests
- Testcontainers
- Kubernetes Deployment

---

## License

This project is licensed under the MIT License.