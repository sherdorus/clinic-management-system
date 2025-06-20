# 🏥 Clinic Management System

A comprehensive REST API for clinic management built with Spring Boot. This backend service provides endpoints to manage doctors, patients, appointments, and medical records.

---

## 📋 Overview

This backend API is designed for healthcare applications, offering RESTful endpoints to support complete clinic operations. It's ideal for integration with web applications, mobile apps, or other healthcare systems.
This project is ideal for showcasing backend development skills as part of a junior or mid-level Java developer portfolio.

---

## ✨ Features

### ✅ Current Functionality
- **Doctor Management API** – CRUD operations for doctors
- **Specialty Management API** – Manage medical specialties
- **Patient Management API** – Patient registration and profile management
- **Appointment System API** – Appointment scheduling and management
- **Visit Management API** – Patient visit tracking
- **Medical Records API** – Track patient medical history
- **Swagger Documentation** – Built-in OpenAPI/Swagger UI for testing

### 🚧 Planned Enhancements
- **Authentication & Authorization**
- **Email Notifications** for appointment reminders
- **Reporting APIs** for analytics and insights

---

## 🛠️ Technology Stack

- **Language:** Java 17
- **Framework:** Spring Boot 3
- **Database:** MySQL 8
- **ORM:** Spring Data JPA (Hibernate)
- **Documentation:** Swagger / OpenAPI 3
- **Build Tool:** Maven
- **Utilities:** Lombok

---

## 📋 Prerequisites

- Java 17 or higher
- MySQL 8.0+
- Maven 3.6+

---

## 🚀 Quick Start

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

Update `src/main/resources/application.properties` with your database credentials:

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

Visit: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

Use this interactive interface to test and explore all API endpoints.

### 6. Load Sample Data (Optional)

For testing purposes, you can import sample data:

```bash
mysql -u your_username -p clinic_management < src/main/resources/db/clinic_test_data.sql
```

This will populate your database with sample doctors, patients, specialties, appointments, and visits.

---

## 🏗️ Project Structure

```
src/main/java/io/sherdor/clinicmanagementsystem/
├── controller/         # REST controllers
├── model/              # Entity classes
├── dto/                # Data transfer objects
├── repository/         # JPA repositories
├── service/            # Business logic
├── config/             # Configuration classes
└── ClinicManagementApplication.java

src/main/resources/
├── db/
│   └── clinic_test_data.sql    # Sample database dump
└── application.properties
```

---

## 🔧 Development Notes

### ☑️ Lombok

This project uses [Lombok](https://projectlombok.org/) to reduce boilerplate code.
Make sure your IDE has the Lombok plugin enabled:

* **IntelliJ IDEA:** Preferences → Plugins → Lombok
* **Eclipse:** Install via Lombok JAR

---

## 🤝 Contributing

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

---

## 🧭 Roadmap

- [ ] Authentication & Authorization
- [ ] Email Notification System
- [ ] Audit Logging
- [ ] Advanced Search and Filtering
- [ ] File Upload (e.g., medical documents)
- [ ] Integration Testing (e.g., TestContainers)

---

## 📧 Contact

**Maintainer:** [sherdorus](https://github.com/sherdorus)

For questions or issues, feel free to open an issue on the [GitHub repo](https://github.com/sherdorus/clinic-management-system).

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).
