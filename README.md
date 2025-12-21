# Clinic Management System

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![AWS](https://img.shields.io/badge/Deployed%20on-AWS-orange)
![Database](https://img.shields.io/badge/Database-MySQL%208-blue)
![Build](https://img.shields.io/badge/Build-Maven-informational)

A REST API for clinic management built with Spring Boot. This backend service provides endpoints to manage doctors, patients, appointments, and medical records.

## Overview

This backend API is designed for healthcare applications, offering RESTful endpoints to support clinic operations. It can be integrated with web or mobile applications.

## Features

### Current Functionality

* Doctor Management API – CRUD operations for doctors
* Specialty Management API – Manage medical specialties
* Patient Management API – Patient registration and profile management
* Appointment System API – Appointment scheduling and management
* Visit Management API – Patient visit tracking
* Medical Records API – Track patient medical history
* Swagger Documentation – OpenAPI/Swagger UI for testing and documentation

### Planned Enhancements

* Authentication and Authorization
* Email notifications for appointment reminders
* Reporting APIs for analytics

## Technology Stack

* Language: Java 17
* Framework: Spring Boot 3
* Database: MySQL 8
* ORM: Spring Data JPA (Hibernate)
* Documentation: Swagger / OpenAPI 3
* Build Tool: Maven
* Utilities: Lombok

## Prerequisites

* Java 17 or higher
* MySQL 8.0 or higher
* Maven 3.6 or higher

## Live Deployment (AWS)

The project is currently deployed and running in **AWS** with a configured database and full backend infrastructure.

* **Base URL:** [https://clinic-app.ubucloud.sbs](https://clinic-app.ubucloud.sbs)
* **Environment:** Production (AWS)
* **Database:** Managed relational database (configured in AWS)

You can use this URL to test the API or connect a frontend application.

> Swagger UI availability depends on production configuration. If enabled, it is usually available at:
> `https://clinic-app.ubucloud.sbs/swagger-ui/index.html`

---

## Quick Start

### 1. Clone the Repository

```bash
git clone https://github.com/sherdorus/clinic-management-system.git
cd clinic-management-system
```

### 2. Create MySQL Database

```sql
CREATE DATABASE clinic_management;
```

### 3. Configure Application Properties

Update `src/main/resources/application.properties` with database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/clinic_management
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 4. Run the Application

```bash
mvn spring-boot:run
```

### 5. Open Swagger UI

Open in browser:

```
http://localhost:8080/swagger-ui/index.html
```

Use this interface to explore API endpoints.

### 6. Load Sample Data (Optional)

To import sample data:

```bash
mysql -u your_username -p clinic_management < src/main/resources/db/clinic_test_data.sql
```

This command populates the database with sample doctors, patients, specialties, appointments, and visits.

## Project Structure

```
src/main/java/io/sherdor/clinicmanagementsystem/
├── controller/
├── enums/
├── entity/
├── dto/
├── repository/
├── service/
├── config/
└── ClinicManagementApplication.java

src/main/resources/
├── db/
│   └── clinic_test_data.sql
└── application.properties
```

## Development Notes

### Lombok

This project uses Lombok to reduce boilerplate code. Ensure your IDE has Lombok support enabled.

## Contributing

1. Fork the repository
2. Create a feature branch:

   ```bash
   git checkout -b feature/your-feature
   ```
3. Commit your changes:

   ```bash
   git commit -m "Add your feature"
   ```
4. Push and open a Pull Request

## Roadmap

* Authentication & Authorization
* Email notification system
* Audit logging
* Advanced search and filtering
* File upload support
* Integration testing

## Contact

Maintainer: sherdorus
For questions or issues, open an issue on the GitHub repository.

## License

This project is licensed under the MIT License.
